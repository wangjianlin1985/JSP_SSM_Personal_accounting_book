// 
// 
// 

package checkcode.patchca.color;

import java.awt.Color;

public class SingleColorFactory implements ColorFactory
{
    private Color color;
    
    public SingleColorFactory() {
        this.color = Color.BLACK;
    }
    
    public SingleColorFactory(final Color color) {
        this.color = color;
    }
    
    @Override
    public Color getColor(final int index) {
        return this.color;
    }
    
    public void setColor(final Color color) {
        this.color = color;
    }
}
