// 
// 
// 

package checkcode.patchca.filter.predefined;

import java.util.ArrayList;
import java.awt.image.BufferedImageOp;
import java.util.List;
import checkcode.patchca.filter.library.DiffuseImageOp;

public class DiffuseRippleFilterFactory extends RippleFilterFactory
{
    protected DiffuseImageOp diffuse;
    
    public DiffuseRippleFilterFactory() {
        this.diffuse = new DiffuseImageOp();
    }
    
    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(this.diffuse);
        return list;
    }
}
