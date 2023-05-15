// 
// 
// 

package checkcode.patchca.text.renderer;

import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.text.AttributedCharacterIterator;
import java.awt.Color;
import java.awt.Font;

public class TextCharacter
{
    private double x;
    private double y;
    private double width;
    private double height;
    private double ascent;
    private double descent;
    private char character;
    private Font font;
    private Color color;
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(final double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(final double height) {
        this.height = height;
    }
    
    public char getCharacter() {
        return this.character;
    }
    
    public void setCharacter(final char character) {
        this.character = character;
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public void setFont(final Font font) {
        this.font = font;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(final Color color) {
        this.color = color;
    }
    
    public double getAscent() {
        return this.ascent;
    }
    
    public void setAscent(final double ascent) {
        this.ascent = ascent;
    }
    
    public double getDescent() {
        return this.descent;
    }
    
    public void setDescent(final double descent) {
        this.descent = descent;
    }
    
    public AttributedCharacterIterator iterator() {
        final AttributedString aString = new AttributedString(String.valueOf(this.character));
        aString.addAttribute(TextAttribute.FONT, this.font, 0, 1);
        return aString.getIterator();
    }
}
