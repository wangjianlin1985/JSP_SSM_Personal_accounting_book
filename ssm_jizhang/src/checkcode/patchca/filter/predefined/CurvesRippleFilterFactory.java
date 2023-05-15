// 
// 
// 

package checkcode.patchca.filter.predefined;

import java.util.ArrayList;
import java.awt.image.BufferedImageOp;
import java.util.List;
import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.filter.library.CurvesImageOp;

public class CurvesRippleFilterFactory extends RippleFilterFactory
{
    protected CurvesImageOp curves;
    
    public CurvesRippleFilterFactory() {
        this.curves = new CurvesImageOp();
    }
    
    public CurvesRippleFilterFactory(final ColorFactory colorFactory) {
        this.curves = new CurvesImageOp();
        this.setColorFactory(colorFactory);
    }
    
    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(this.curves);
        return list;
    }
    
    public void setStrokeMin(final float strokeMin) {
        this.curves.setStrokeMin(strokeMin);
    }
    
    public void setStrokeMax(final float strokeMax) {
        this.curves.setStrokeMax(strokeMax);
    }
    
    public void setColorFactory(final ColorFactory colorFactory) {
        this.curves.setColorFactory(colorFactory);
    }
}
