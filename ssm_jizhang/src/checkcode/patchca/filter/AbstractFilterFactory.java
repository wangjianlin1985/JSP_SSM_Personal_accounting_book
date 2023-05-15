// 
// 
// 

package checkcode.patchca.filter;

import java.util.Iterator;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.util.List;

public abstract class AbstractFilterFactory implements FilterFactory
{
    protected abstract List<BufferedImageOp> getFilters();
    
    @Override
    public BufferedImage applyFilters(BufferedImage source) {
        BufferedImage dest = source;
        for (final BufferedImageOp filter : this.getFilters()) {
            dest = filter.filter(dest, null);
        }
        final int x = (source.getWidth() - dest.getWidth()) / 2;
        final int y = (source.getHeight() - dest.getHeight()) / 2;
        source = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        source.getGraphics().drawImage(dest, x, y, null);
        return source;
    }
}
