// 
// 
// 

package checkcode.patchca.text.renderer;

import java.util.Iterator;
import java.util.ArrayList;

public class TextString
{
    private ArrayList<TextCharacter> characters;
    
    public TextString() {
        this.characters = new ArrayList<TextCharacter>();
    }
    
    public void clear() {
        this.characters.clear();
    }
    
    public void addCharacter(final TextCharacter tc) {
        this.characters.add(tc);
    }
    
    public ArrayList<TextCharacter> getCharacters() {
        return this.characters;
    }
    
    public double getWidth() {
        double minx = 0.0;
        double maxx = 0.0;
        boolean first = true;
        for (final TextCharacter tc : this.characters) {
            if (first) {
                minx = tc.getX();
                maxx = tc.getX() + tc.getWidth();
                first = false;
            }
            else {
                if (minx > tc.getX()) {
                    minx = tc.getX();
                }
                if (maxx >= tc.getX() + tc.getWidth()) {
                    continue;
                }
                maxx = tc.getX() + tc.getWidth();
            }
        }
        return maxx - minx;
    }
    
    public double getHeight() {
        double miny = 0.0;
        double maxy = 0.0;
        boolean first = true;
        for (final TextCharacter tc : this.characters) {
            if (first) {
                miny = tc.getY();
                maxy = tc.getY() + tc.getHeight();
                first = false;
            }
            else {
                if (miny > tc.getY()) {
                    miny = tc.getY();
                }
                if (maxy >= tc.getY() + tc.getHeight()) {
                    continue;
                }
                maxy = tc.getY() + tc.getHeight();
            }
        }
        return maxy - miny;
    }
}
