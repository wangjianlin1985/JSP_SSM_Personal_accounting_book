// 
// 
// 

package checkcode.patchca.demo;

import java.io.IOException;
import java.io.OutputStream;
import checkcode.patchca.service.CaptchaService;
import checkcode.patchca.utils.encoder.EncoderHelper;
import java.io.FileOutputStream;
import checkcode.patchca.filter.FilterFactory;
import checkcode.patchca.filter.predefined.CurvesRippleFilterFactory;
import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.color.SingleColorFactory;
import java.awt.Color;
import checkcode.patchca.service.ConfigurableCaptchaService;

public class Sample
{
    public static void main(final String[] args) throws IOException {
        final ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        final FileOutputStream fos = new FileOutputStream("F://patcha_demo.png");
        EncoderHelper.getChallangeAndWriteImage(cs, "png", fos);
        fos.close();
    }
}
