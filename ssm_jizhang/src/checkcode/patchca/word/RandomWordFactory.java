// 
// 
// 

package checkcode.patchca.word;

import java.util.Random;

public class RandomWordFactory implements WordFactory
{
    protected String characters;
    protected int minLength;
    protected int maxLength;
    
    public void setCharacters(final String characters) {
        this.characters = characters;
    }
    
    public void setMinLength(final int minLength) {
        this.minLength = minLength;
    }
    
    public void setMaxLength(final int maxLength) {
        this.maxLength = maxLength;
    }
    
    public RandomWordFactory() {
        this.characters = "absdegkmnopwx23456789";
        this.minLength = 4;
        this.maxLength = 4;
    }
    
    @Override
    public String getNextWord() {
        final Random rnd = new Random();
        final StringBuffer sb = new StringBuffer();
        for (int l = this.minLength + ((this.maxLength > this.minLength) ? rnd.nextInt(this.maxLength - this.minLength) : 0), i = 0; i < l; ++i) {
            final int j = rnd.nextInt(this.characters.length());
            sb.append(this.characters.charAt(j));
        }
        return sb.toString();
    }
}
