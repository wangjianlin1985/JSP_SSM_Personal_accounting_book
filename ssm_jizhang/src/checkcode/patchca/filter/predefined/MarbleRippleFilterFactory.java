// 
// 
// 

package checkcode.patchca.filter.predefined;

import java.util.ArrayList;
import java.awt.image.BufferedImageOp;
import java.util.List;
import checkcode.patchca.filter.library.MarbleImageOp;

public class MarbleRippleFilterFactory extends RippleFilterFactory
{
    protected MarbleImageOp marble;
    
    public MarbleRippleFilterFactory() {
        this.marble = new MarbleImageOp();
    }
    
    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(this.marble);
        return list;
    }
}
