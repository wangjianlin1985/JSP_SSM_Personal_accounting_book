// 
// 
// 

package checkcode.patchca.text.renderer;

import java.util.Iterator;

public class SimpleTextRenderer extends AbstractTextRenderer
{
    @Override
    protected void arrangeCharacters(final int width, final int height, final TextString ts) {
        double x = this.leftMargin;
        for (final TextCharacter tc : ts.getCharacters()) {
            final double y = this.topMargin + (height + tc.getAscent() * 0.7) / 2.0;
            tc.setX(x);
            tc.setY(y);
            x += tc.getWidth();
        }
    }
}
