// 
// 
// 

package checkcode.patchca.background;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.GradientPaint;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class GradientBackgroundFactory implements BackgroundFactory
{
    private Color startColor;
    private Color endColor;
    private Direction direction;
    private static /* synthetic */ int[] $SWITCH_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction;
    
    public GradientBackgroundFactory() {
        this(new Color(192, 192, 0), new Color(192, 128, 128), Direction.Horizontal);
    }
    
    public GradientBackgroundFactory(final Color startColor, final Color endColor, final Direction direction) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.direction = direction;
    }
    
    @Override
    public void fillBackground(final BufferedImage dest) {
        float x1 = 0.0f;
        float y1 = 0.0f;
        float x2 = 0.0f;
        float y2 = 0.0f;
        switch ($SWITCH_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction()[this.direction.ordinal()]) {
            default: {
                x1 = 0.0f;
                y1 = 0.0f;
                x2 = dest.getWidth();
                y2 = 0.0f;
                break;
            }
            case 2: {
                x1 = 0.0f;
                y1 = 0.0f;
                x2 = 0.0f;
                y2 = dest.getHeight();
                break;
            }
            case 4: {
                x1 = 0.0f;
                y1 = dest.getHeight();
                x2 = dest.getWidth();
                y2 = 0.0f;
                break;
            }
            case 3: {
                x1 = 0.0f;
                y1 = 0.0f;
                x2 = dest.getWidth();
                y2 = dest.getHeight();
                break;
            }
        }
        final GradientPaint gp = new GradientPaint(x1, y1, this.startColor, x2, y2, this.endColor);
        final Graphics2D g = dest.createGraphics();
        g.setPaint(gp);
        g.fillRect(0, 0, dest.getWidth(), dest.getHeight());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction() {
        final int[] $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction = GradientBackgroundFactory.$SWITCH_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction;
        if ($switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction != null) {
            return $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction;
        }
        final int[] $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction2 = new int[Direction.values().length];
        try {
            $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction2[Direction.BottomLeftTopRight.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction2[Direction.Horizontal.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction2[Direction.TopLeftBottomRight.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction2[Direction.Vertical.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GradientBackgroundFactory.$SWITCH_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction = $switch_TABLE$checkcode$patchca$background$GradientBackgroundFactory$Direction2;
    }
    
    public enum Direction
    {
        Horizontal("Horizontal", 0), 
        Vertical("Vertical", 1), 
        TopLeftBottomRight("TopLeftBottomRight", 2), 
        BottomLeftTopRight("BottomLeftTopRight", 3);
        
        private Direction(final String s, final int n) {
        }
    }
}
