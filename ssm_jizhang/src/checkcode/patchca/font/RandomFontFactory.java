// 
// 
// 

package checkcode.patchca.font;

import java.util.Random;
import java.awt.Font;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class RandomFontFactory implements FontFactory
{
    protected List<String> families;
    protected int minSize;
    protected int maxSize;
    protected boolean randomStyle;
    
    public RandomFontFactory() {
        (this.families = new ArrayList<String>()).add("Verdana");
        this.families.add("Tahoma");
        this.minSize = 45;
        this.maxSize = 45;
    }
    
    public RandomFontFactory(final List<String> families) {
        this();
        this.families = families;
    }
    
    public RandomFontFactory(final String[] families) {
        this();
        this.families = Arrays.asList(families);
    }
    
    public RandomFontFactory(final int size, final List<String> families) {
        this(families);
        this.maxSize = size;
        this.minSize = size;
    }
    
    public RandomFontFactory(final int size, final String[] families) {
        this(families);
        this.maxSize = size;
        this.minSize = size;
    }
    
    public void setFamilies(final List<String> families) {
        this.families = families;
    }
    
    public void setMinSize(final int minSize) {
        this.minSize = minSize;
    }
    
    public void setMaxSize(final int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void setRandomStyle(final boolean randomStyle) {
        this.randomStyle = randomStyle;
    }
    
    @Override
    public Font getFont(final int index) {
        final Random r = new Random();
        final String family = this.families.get(r.nextInt(this.families.size()));
        final boolean bold = r.nextBoolean() && this.randomStyle;
        int size = this.minSize;
        if (this.maxSize - this.minSize > 0) {
            size += r.nextInt(this.maxSize - this.minSize);
        }
        return new Font(family, bold ? 1 : 0, size);
    }
}
