// 
// 
// 

package checkcode.patchca.utils.encoder;

import java.io.IOException;
import checkcode.patchca.service.Captcha;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.OutputStream;
import checkcode.patchca.service.CaptchaService;

public class EncoderHelper
{
    public static String getChallangeAndWriteImage(final CaptchaService service, final String format, final OutputStream os) throws IOException {
        final Captcha captcha = service.getCaptcha();
        ImageIO.write(captcha.getImage(), format, os);
        return captcha.getChallenge();
    }
}
