// 
// 
// 

package checkcode.patchca.background;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import checkcode.patchca.color.SingleColorFactory;
import java.awt.Color;
import checkcode.patchca.color.ColorFactory;

public class SingleColorBackgroundFactory implements BackgroundFactory
{
    private ColorFactory colorFactory;
    
    public SingleColorBackgroundFactory() {
        this.colorFactory = new SingleColorFactory(Color.WHITE);
    }
    
    public SingleColorBackgroundFactory(final Color color) {
        this.colorFactory = new SingleColorFactory(color);
    }
    
    public void setColorFactory(final ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }
    
    @Override
    public void fillBackground(final BufferedImage dest) {
        final Graphics g = dest.getGraphics();
        g.setColor(this.colorFactory.getColor(0));
        g.fillRect(0, 0, dest.getWidth(), dest.getHeight());
    }
}
