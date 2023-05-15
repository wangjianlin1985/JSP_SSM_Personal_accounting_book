// 
// 
// 

package checkcode.patchca.service;

import java.awt.image.BufferedImage;
import checkcode.patchca.filter.FilterFactory;
import checkcode.patchca.text.renderer.TextRenderer;
import checkcode.patchca.background.BackgroundFactory;
import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.word.WordFactory;
import checkcode.patchca.font.FontFactory;

public abstract class AbstractCaptchaService implements CaptchaService
{
    protected FontFactory fontFactory;
    protected WordFactory wordFactory;
    protected ColorFactory colorFactory;
    protected BackgroundFactory backgroundFactory;
    protected TextRenderer textRenderer;
    protected FilterFactory filterFactory;
    protected int width;
    protected int height;
    
    public void setFontFactory(final FontFactory fontFactory) {
        this.fontFactory = fontFactory;
    }
    
    public void setWordFactory(final WordFactory wordFactory) {
        this.wordFactory = wordFactory;
    }
    
    public void setColorFactory(final ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }
    
    public void setBackgroundFactory(final BackgroundFactory backgroundFactory) {
        this.backgroundFactory = backgroundFactory;
    }
    
    public void setTextRenderer(final TextRenderer textRenderer) {
        this.textRenderer = textRenderer;
    }
    
    public void setFilterFactory(final FilterFactory filterFactory) {
        this.filterFactory = filterFactory;
    }
    
    public FontFactory getFontFactory() {
        return this.fontFactory;
    }
    
    public WordFactory getWordFactory() {
        return this.wordFactory;
    }
    
    public ColorFactory getColorFactory() {
        return this.colorFactory;
    }
    
    public BackgroundFactory getBackgroundFactory() {
        return this.backgroundFactory;
    }
    
    public TextRenderer getTextRenderer() {
        return this.textRenderer;
    }
    
    public FilterFactory getFilterFactory() {
        return this.filterFactory;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    @Override
    public Captcha getCaptcha() {
        BufferedImage bufImage = new BufferedImage(this.width, this.height, 2);
        this.backgroundFactory.fillBackground(bufImage);
        final String word = this.wordFactory.getNextWord();
        this.textRenderer.draw(word, bufImage, this.fontFactory, this.colorFactory);
        bufImage = this.filterFactory.applyFilters(bufImage);
        return new Captcha(word, bufImage);
    }
}
