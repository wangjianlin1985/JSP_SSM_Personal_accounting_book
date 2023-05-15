// 
// 
// 

package checkcode.patchca.color;

import java.awt.Color;

public class GradientColorFactory implements ColorFactory
{
    private Color start;
    private Color step;
    
    public GradientColorFactory() {
        this.start = new Color(192, 192, 0);
        this.step = new Color(192, 128, 128);
    }
    
    @Override
    public Color getColor(final int index) {
        return new Color((this.start.getRed() + this.step.getRed() * index) % 256, (this.start.getGreen() + this.step.getGreen() * index) % 256, (this.start.getBlue() + this.step.getBlue() * index) % 256);
    }
    
    public void setStart(final Color start) {
        this.start = start;
    }
    
    public void setStep(final Color step) {
        this.step = step;
    }
}
