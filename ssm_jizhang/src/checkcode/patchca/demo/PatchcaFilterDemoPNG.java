// 
// 
// 

package checkcode.patchca.demo;

import java.io.OutputStream;
import checkcode.patchca.service.CaptchaService;
import checkcode.patchca.utils.encoder.EncoderHelper;
import java.io.FileOutputStream;
import checkcode.patchca.filter.predefined.DiffuseRippleFilterFactory;
import checkcode.patchca.filter.predefined.WobbleRippleFilterFactory;
import checkcode.patchca.filter.predefined.DoubleRippleFilterFactory;
import checkcode.patchca.filter.predefined.MarbleRippleFilterFactory;
import checkcode.patchca.filter.FilterFactory;
import checkcode.patchca.filter.predefined.CurvesRippleFilterFactory;
import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.color.SingleColorFactory;
import java.awt.Color;
import checkcode.patchca.service.ConfigurableCaptchaService;

public class PatchcaFilterDemoPNG
{
    public static void main(final String[] args) throws Exception {
        for (int counter = 0; counter < 5; ++counter) {
            final ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
            cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
            switch (counter % 5) {
                case 0: {
                    cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                    break;
                }
                case 1: {
                    cs.setFilterFactory(new MarbleRippleFilterFactory());
                    break;
                }
                case 2: {
                    cs.setFilterFactory(new DoubleRippleFilterFactory());
                    break;
                }
                case 3: {
                    cs.setFilterFactory(new WobbleRippleFilterFactory());
                    break;
                }
                case 4: {
                    cs.setFilterFactory(new DiffuseRippleFilterFactory());
                    break;
                }
            }
            final FileOutputStream fos = new FileOutputStream("patcha_demo" + counter + ".png");
            EncoderHelper.getChallangeAndWriteImage(cs, "png", fos);
            fos.close();
        }
    }
}
