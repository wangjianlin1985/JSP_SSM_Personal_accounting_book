// 
// 
// 

package checkcode.patchca.filter.library;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import java.awt.image.IndexColorModel;
import java.awt.image.ColorModel;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.image.BufferedImageOp;

public abstract class AbstractImageOp implements BufferedImageOp
{
    public static final int EDGE_ZERO = 0;
    public static final int EDGE_MIRROR = 1;
    public static final int EDGE_CLAMP = 2;
    protected int edgeMode;
    protected RenderingHints hints;
    
    public int getEdgeMode() {
        return this.edgeMode;
    }
    
    public void setEdgeMode(final int edgeMode) {
        this.edgeMode = edgeMode;
    }
    
    protected int getPixel(final int[] pixels, int x, int y, final int width, int height, final int edgeMode) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return pixels[x + y * width];
        }
        if (edgeMode == 0) {
            return 0;
        }
        if (edgeMode == 2) {
            if (x < 0) {
                x = 0;
            }
            else if (x >= width) {
                x = width - 1;
            }
            if (y < 0) {
                y = 0;
            }
            else if (y >= height) {
                y = height - 1;
            }
            return pixels[x + y * width];
        }
        if (x < 0) {
            x = -x;
        }
        else if (x >= width) {
            x = width + width - x - 1;
        }
        if (y < 0) {
            y = -y;
        }
        else if (y > height) {
            height = (y = height - y - 1);
        }
        try {
            return pixels[x + y * width];
        }
        catch (Exception e) {
            return 0;
        }
    }
    
    private int linear(final int from, final int to, final int shift, final double d) {
        return (int)Math.floor((from >> shift & 0xFF) + d * ((to >> shift & 0xFF) - (from >> shift & 0xFF))) << shift;
    }
    
    private int linear(final int from, final int to, final double d) {
        int c = 0;
        for (int i = 0; i < 4; ++i) {
            c += this.linear(from, to, i * 8, d);
        }
        return c;
    }
    
    protected int bilinear(final int nw, final int ne, final int sw, final int se, final double xd, final double yd) {
        return this.linear(this.linear(nw, ne, xd), this.linear(sw, se, xd), yd);
    }
    
    protected int getPixelBilinear(final int[] pixels, final double x, final double y, final int width, final int height, final int edgeMode) {
        final int xi = (int)Math.floor(x);
        final int yi = (int)Math.floor(y);
        final double xd = x - xi;
        final double yd = y - yi;
        final int nw = this.getPixel(pixels, xi, yi, width, height, edgeMode);
        final int ne = this.getPixel(pixels, xi + 1, yi, width, height, edgeMode);
        final int sw = this.getPixel(pixels, xi, yi + 1, width, height, edgeMode);
        final int se = this.getPixel(pixels, xi + 1, yi + 1, width, height, edgeMode);
        return this.bilinear(nw, ne, sw, se, xd, yd);
    }
    
    protected int limit(int v, final int min, final int max) {
        if (v < min) {
            v = min;
        }
        else if (v > max) {
            v = max;
        }
        return v;
    }
    
    protected int limitByte(final int v) {
        return this.limit(v, 0, 255);
    }
    
    protected void filter(final int[] inPixels, final int[] outPixels, final int width, final int height) {
    }
    
    @Override
    public BufferedImage filter(final BufferedImage src, BufferedImage dest) {
        if (dest == null) {
            dest = this.createCompatibleDestImage(src, null);
        }
        final int width = src.getWidth();
        final int height = src.getHeight();
        final int[] inPixels = new int[width * height];
        final int[] outPixels = new int[width * height];
        src.getRaster().getDataElements(0, 0, width, height, inPixels);
        this.filter(inPixels, outPixels, width, height);
        dest.getRaster().setDataElements(0, 0, width, height, outPixels);
        return dest;
    }
    
    @Override
    public BufferedImage createCompatibleDestImage(final BufferedImage src, ColorModel destCM) {
        if (destCM == null) {
            destCM = src.getColorModel();
            if (destCM instanceof IndexColorModel) {
                destCM = ColorModel.getRGBdefault();
            }
        }
        return new BufferedImage(destCM, destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight()), destCM.isAlphaPremultiplied(), null);
    }
    
    @Override
    public Rectangle2D getBounds2D(final BufferedImage src) {
        return src.getRaster().getBounds();
    }
    
    @Override
    public Point2D getPoint2D(final Point2D srcPt, Point2D dstPt) {
        if (dstPt == null) {
            dstPt = new Point2D.Float();
        }
        dstPt.setLocation(srcPt.getX(), srcPt.getY());
        return dstPt;
    }
    
    @Override
    public RenderingHints getRenderingHints() {
        return this.hints;
    }
}
