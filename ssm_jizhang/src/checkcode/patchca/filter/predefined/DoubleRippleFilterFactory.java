// 
// 
// 

package checkcode.patchca.filter.predefined;

import java.util.ArrayList;
import checkcode.patchca.filter.library.DoubleRippleImageOp;
import java.awt.image.BufferedImageOp;
import java.util.List;
import checkcode.patchca.filter.AbstractFilterFactory;

public class DoubleRippleFilterFactory extends AbstractFilterFactory
{
    protected List<BufferedImageOp> filters;
    protected DoubleRippleImageOp ripple;
    
    public DoubleRippleFilterFactory() {
        this.ripple = new DoubleRippleImageOp();
    }
    
    public List<BufferedImageOp> getFilters() {
        if (this.filters == null) {
            (this.filters = new ArrayList<BufferedImageOp>()).add(this.ripple);
        }
        return this.filters;
    }
}
