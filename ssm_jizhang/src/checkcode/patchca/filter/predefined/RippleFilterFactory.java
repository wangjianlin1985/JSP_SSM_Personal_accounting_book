// 
// 
// 

package checkcode.patchca.filter.predefined;

import java.util.Collection;
import java.util.ArrayList;
import checkcode.patchca.filter.library.RippleImageOp;
import java.awt.image.BufferedImageOp;
import java.util.List;
import checkcode.patchca.filter.AbstractFilterFactory;

public class RippleFilterFactory extends AbstractFilterFactory
{
    protected List<BufferedImageOp> filters;
    protected RippleImageOp ripple;
    
    public RippleFilterFactory() {
        this.ripple = new RippleImageOp();
    }
    
    protected List<BufferedImageOp> getPreRippleFilters() {
        return new ArrayList<BufferedImageOp>();
    }
    
    protected List<BufferedImageOp> getPostRippleFilters() {
        return new ArrayList<BufferedImageOp>();
    }
    
    public List<BufferedImageOp> getFilters() {
        if (this.filters == null) {
            (this.filters = new ArrayList<BufferedImageOp>()).addAll(this.getPreRippleFilters());
            this.filters.add(this.ripple);
            this.filters.addAll(this.getPostRippleFilters());
        }
        return this.filters;
    }
}
