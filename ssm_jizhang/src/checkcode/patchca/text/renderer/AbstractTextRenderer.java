// 
// 
// 

package checkcode.patchca.text.renderer;

import java.awt.geom.Rectangle2D;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.util.Iterator;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.font.FontFactory;
import java.awt.image.BufferedImage;

public abstract class AbstractTextRenderer implements TextRenderer
{
    protected int leftMargin;
    protected int rightMargin;
    protected int topMargin;
    protected int bottomMargin;
    
    protected abstract void arrangeCharacters(final int p0, final int p1, final TextString p2);
    
    public AbstractTextRenderer() {
        final int n = 5;
        this.rightMargin = n;
        this.leftMargin = n;
        final int n2 = 5;
        this.bottomMargin = n2;
        this.topMargin = n2;
    }
    
    @Override
    public void setLeftMargin(final int leftMargin) {
        this.leftMargin = leftMargin;
    }
    
    @Override
    public void setRightMargin(final int rightMargin) {
        this.rightMargin = rightMargin;
    }
    
    @Override
    public void setTopMargin(final int topMargin) {
        this.topMargin = topMargin;
    }
    
    @Override
    public void setBottomMargin(final int bottomMargin) {
        this.bottomMargin = bottomMargin;
    }
    
    @Override
    public void draw(final String text, final BufferedImage canvas, final FontFactory fontFactory, final ColorFactory colorFactory) {
        final Graphics2D g = (Graphics2D)canvas.getGraphics();
        final TextString ts = this.convertToCharacters(text, g, fontFactory, colorFactory);
        this.arrangeCharacters(canvas.getWidth(), canvas.getHeight(), ts);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        for (final TextCharacter tc : ts.getCharacters()) {
            g.setColor(tc.getColor());
            g.drawString(tc.iterator(), (float)tc.getX(), (float)tc.getY());
        }
    }
    
    protected TextString convertToCharacters(final String text, final Graphics2D g, final FontFactory fontFactory, final ColorFactory colorFactory) {
        final TextString characters = new TextString();
        final FontRenderContext frc = g.getFontRenderContext();
        double lastx = 0.0;
        for (int i = 0; i < text.length(); ++i) {
            final Font font = fontFactory.getFont(i);
            final char c = text.charAt(i);
            final FontMetrics fm = g.getFontMetrics(font);
            final Rectangle2D bounds = font.getStringBounds(String.valueOf(c), frc);
            final TextCharacter tc = new TextCharacter();
            tc.setCharacter(c);
            tc.setFont(font);
            tc.setWidth(fm.charWidth(c));
            tc.setHeight(fm.getAscent() + fm.getDescent());
            tc.setAscent(fm.getAscent());
            tc.setDescent(fm.getDescent());
            tc.setX(lastx);
            tc.setY(0.0);
            tc.setFont(font);
            tc.setColor(colorFactory.getColor(i));
            lastx += bounds.getWidth();
            characters.addCharacter(tc);
        }
        return characters;
    }
}
