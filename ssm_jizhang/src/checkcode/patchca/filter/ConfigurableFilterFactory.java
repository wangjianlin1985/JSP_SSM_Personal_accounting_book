// 
// 
// 

package checkcode.patchca.filter;

import java.awt.image.BufferedImageOp;
import java.util.List;

public class ConfigurableFilterFactory extends AbstractFilterFactory
{
    private List<BufferedImageOp> filters;
    
    public List<BufferedImageOp> getFilters() {
        return this.filters;
    }
    
    public void setFilters(final List<BufferedImageOp> filters) {
        this.filters = filters;
    }
}
