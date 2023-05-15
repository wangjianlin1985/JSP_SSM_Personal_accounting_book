// 
// 
// 

package checkcode.patchca.text.renderer;

import java.util.Iterator;
import java.util.Random;

public class RandomYBestFitTextRenderer extends AbstractTextRenderer
{
    @Override
    protected void arrangeCharacters(final int width, int height, final TextString ts) {
        final double widthRemaining = (width - ts.getWidth() - this.leftMargin - this.rightMargin) / ts.getCharacters().size();
        final double vmiddle = height / 2;
        double x = this.leftMargin + widthRemaining / 2.0;
        final Random r = new Random();
        height -= this.topMargin + this.bottomMargin;
        for (final TextCharacter tc : ts.getCharacters()) {
            final double heightRemaining = height - tc.getHeight();
            final double y = vmiddle + 0.35 * tc.getAscent() + (1.0 - 2.0 * r.nextDouble()) * heightRemaining;
            tc.setX(x);
            tc.setY(y);
            x += tc.getWidth() + widthRemaining;
        }
    }
}
