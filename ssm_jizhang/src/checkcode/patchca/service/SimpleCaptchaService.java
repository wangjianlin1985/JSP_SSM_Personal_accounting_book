// 
// 
// 

package checkcode.patchca.service;

import checkcode.patchca.color.SingleColorFactory;
import checkcode.patchca.text.renderer.BestFitTextRenderer;
import checkcode.patchca.font.RandomFontFactory;
import checkcode.patchca.word.AdaptiveRandomWordFactory;
import checkcode.patchca.background.SingleColorBackgroundFactory;
import checkcode.patchca.filter.FilterFactory;
import java.awt.Color;

public class SimpleCaptchaService extends AbstractCaptchaService
{
    public SimpleCaptchaService(final int width, final int height, final Color textColor, final Color backgroundColor, final int fontSize, final FilterFactory ff) {
        this.backgroundFactory = new SingleColorBackgroundFactory(backgroundColor);
        this.wordFactory = new AdaptiveRandomWordFactory();
        this.fontFactory = new RandomFontFactory();
        this.textRenderer = new BestFitTextRenderer();
        this.colorFactory = new SingleColorFactory(textColor);
        this.filterFactory = ff;
        this.width = width;
        this.height = height;
    }
    
    public SimpleCaptchaService(final int width, final int height, final Color textColor, final Color backgroundColor, final int fontSize, final String[] fontNames, final FilterFactory ff) {
        this.backgroundFactory = new SingleColorBackgroundFactory(backgroundColor);
        this.wordFactory = new AdaptiveRandomWordFactory();
        this.fontFactory = new RandomFontFactory(fontNames);
        this.textRenderer = new BestFitTextRenderer();
        this.colorFactory = new SingleColorFactory(textColor);
        this.filterFactory = ff;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public Captcha getCaptcha() {
        return null;
    }
}
