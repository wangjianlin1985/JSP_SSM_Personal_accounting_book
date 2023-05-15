// 
// 
// 

package checkcode.patchca.filter.predefined;

import java.util.ArrayList;
import java.awt.image.BufferedImageOp;
import java.util.List;
import checkcode.patchca.filter.library.WobbleImageOp;

public class WobbleRippleFilterFactory extends RippleFilterFactory
{
    protected WobbleImageOp wobble;
    
    public WobbleRippleFilterFactory() {
        this.wobble = new WobbleImageOp();
    }
    
    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(this.wobble);
        return list;
    }
}
