// 
// 
// 

package checkcode.patchca.service;

import checkcode.patchca.filter.predefined.CurvesRippleFilterFactory;
import checkcode.patchca.color.SingleColorFactory;
import checkcode.patchca.text.renderer.BestFitTextRenderer;
import checkcode.patchca.font.RandomFontFactory;
import checkcode.patchca.word.AdaptiveRandomWordFactory;
import checkcode.patchca.background.SingleColorBackgroundFactory;

public class ConfigurableCaptchaService extends AbstractCaptchaService
{
    public ConfigurableCaptchaService() {
        this.backgroundFactory = new SingleColorBackgroundFactory();
        this.wordFactory = new AdaptiveRandomWordFactory();
        this.fontFactory = new RandomFontFactory();
        this.textRenderer = new BestFitTextRenderer();
        this.colorFactory = new SingleColorFactory();
        this.filterFactory = new CurvesRippleFilterFactory(this.colorFactory);
        this.textRenderer.setLeftMargin(10);
        this.textRenderer.setRightMargin(10);
        this.width = 140;
        this.height = 60;
    }
}
