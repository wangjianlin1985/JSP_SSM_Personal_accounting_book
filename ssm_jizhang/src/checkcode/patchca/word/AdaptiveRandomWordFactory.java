// 
// 
// 

package checkcode.patchca.word;

import java.util.Random;

public class AdaptiveRandomWordFactory extends RandomWordFactory
{
    protected String wideCharacters;
    
    public void setWideCharacters(final String wideCharacters) {
        this.wideCharacters = wideCharacters;
    }
    
    public AdaptiveRandomWordFactory() {
        this.characters = "absdegkmnopwx23456789";
        this.wideCharacters = "mw";
    }
    
    @Override
    public String getNextWord() {
        final Random rnd = new Random();
        final StringBuffer sb = new StringBuffer();
        final StringBuffer chars = new StringBuffer(this.characters);
        for (int l = this.minLength + ((this.maxLength > this.minLength) ? rnd.nextInt(this.maxLength - this.minLength) : 0), i = 0; i < l; ++i) {
            final int j = rnd.nextInt(chars.length());
            final char c = chars.charAt(j);
            if (this.wideCharacters.indexOf(c) != -1) {
                for (int k = 0; k < this.wideCharacters.length(); ++k) {
                    final int idx = chars.indexOf(String.valueOf(this.wideCharacters.charAt(k)));
                    if (idx != -1) {
                        chars.deleteCharAt(idx);
                    }
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
