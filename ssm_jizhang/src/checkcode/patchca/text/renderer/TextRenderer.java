// 
// 
// 

package checkcode.patchca.text.renderer;

import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.font.FontFactory;
import java.awt.image.BufferedImage;

public interface TextRenderer
{
    void setLeftMargin(int p0);
    
    void setRightMargin(int p0);
    
    void setTopMargin(int p0);
    
    void setBottomMargin(int p0);
    
    void draw(String p0, BufferedImage p1, FontFactory p2, ColorFactory p3);
}
