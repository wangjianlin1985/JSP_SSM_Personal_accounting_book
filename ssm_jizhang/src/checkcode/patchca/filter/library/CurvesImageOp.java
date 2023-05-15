// 
// 
// 

package checkcode.patchca.filter.library;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.util.Random;
import java.util.Map;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.image.ColorModel;
import java.awt.image.BufferedImage;
import checkcode.patchca.color.SingleColorFactory;
import checkcode.patchca.color.ColorFactory;

public class CurvesImageOp extends AbstractImageOp
{
    private float strokeMin;
    private float strokeMax;
    private ColorFactory colorFactory;
    
    public CurvesImageOp() {
        this.colorFactory = new SingleColorFactory();
    }
    
    public float getStrokeMin() {
        return this.strokeMin;
    }
    
    public void setStrokeMin(final float strokeMin) {
        this.strokeMin = strokeMin;
    }
    
    public float getStrokeMax() {
        return this.strokeMax;
    }
    
    public void setStrokeMax(final float strokeMax) {
        this.strokeMax = strokeMax;
    }
    
    public ColorFactory getColorFactory() {
        return this.colorFactory;
    }
    
    public void setColorFactory(final ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }
    
    private double hermiteSpline(final double x1, final double a1, final double x2, final double a2, final double t) {
        final double t2 = t * t;
        final double t3 = t2 * t;
        final double b = -a2 - 2.0 * a1 - 3.0 * x1 + 3.0 * x2;
        final double a3 = a2 + a1 + 2.0 * x1 - 2.0 * x2;
        return a3 * t3 + b * t2 + a1 * t + x1;
    }
    
    private double catmullRomSpline(final double x0, final double x1, final double x2, final double x3, final double t) {
        final double a1 = (x2 - x0) / 2.0;
        final double a2 = (x3 - x1) / 2.0;
        return this.hermiteSpline(x1, a1, x2, a2, t);
    }
    
    @Override
    public BufferedImage filter(final BufferedImage src, BufferedImage dest) {
        if (dest == null) {
            dest = this.createCompatibleDestImage(src, null);
        }
        double width = dest.getWidth();
        final double height = dest.getHeight();
        final Graphics2D g2 = (Graphics2D)src.getGraphics();
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        final Random r = new Random();
        final int cp = 4 + r.nextInt(3);
        final int[] xPoints = new int[cp];
        final int[] yPoints = new int[cp];
        width -= 10.0;
        for (int i = 0; i < cp; ++i) {
            xPoints[i] = (int)(5.0 + i * width / (cp - 1));
            yPoints[i] = (int)(height * (r.nextDouble() * 0.5 + 0.2));
        }
        final int subsections = 6;
        final int[] xPointsSpline = new int[(cp - 1) * subsections];
        final int[] yPointsSpline = new int[(cp - 1) * subsections];
        for (int j = 0; j < cp - 1; ++j) {
            final double x0 = (j > 0) ? xPoints[j - 1] : (2 * xPoints[j] - xPoints[j + 1]);
            final double x = xPoints[j];
            final double x2 = xPoints[j + 1];
            final double x3 = (j + 2 < cp) ? xPoints[j + 2] : (2 * xPoints[j + 1] - xPoints[j]);
            final double y0 = (j > 0) ? yPoints[j - 1] : (2 * yPoints[j] - yPoints[j + 1]);
            final double y = yPoints[j];
            final double y2 = yPoints[j + 1];
            final double y3 = (j + 2 < cp) ? yPoints[j + 2] : (2 * yPoints[j + 1] - yPoints[j]);
            for (int k = 0; k < subsections; ++k) {
                xPointsSpline[j * subsections + k] = (int)this.catmullRomSpline(x0, x, x2, x3, 1.0 / subsections * k);
                yPointsSpline[j * subsections + k] = (int)this.catmullRomSpline(y0, y, y2, y3, 1.0 / subsections * k);
            }
        }
        for (int j = 0; j < xPointsSpline.length - 1; ++j) {
            g2.setColor(this.colorFactory.getColor(j));
            g2.setStroke(new BasicStroke(2.0f + 2.0f * r.nextFloat()));
            g2.drawLine(xPointsSpline[j], yPointsSpline[j], xPointsSpline[j + 1], yPointsSpline[j + 1]);
        }
        return src;
    }
}
