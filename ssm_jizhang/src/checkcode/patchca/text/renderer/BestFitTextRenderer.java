// 
// 
// 

package checkcode.patchca.text.renderer;

import java.util.Iterator;

public class BestFitTextRenderer extends AbstractTextRenderer
{
    @Override
    protected void arrangeCharacters(final int width, int height, final TextString ts) {
        final double widthRemaining = (width - ts.getWidth() - this.leftMargin - this.rightMargin) / ts.getCharacters().size();
        double x = this.leftMargin + widthRemaining / 2.0;
        height -= this.topMargin + this.bottomMargin;
        for (final TextCharacter tc : ts.getCharacters()) {
            final double y = this.topMargin + (height + tc.getAscent() * 0.7) / 2.0;
            tc.setX(x);
            tc.setY(y);
            x += tc.getWidth() + widthRemaining;
        }
    }
}
