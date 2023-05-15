// 
// 
// 

package checkcode.patchca.service;

import java.awt.image.BufferedImage;

public class Captcha
{
    private String challenge;
    private BufferedImage image;
    
    public Captcha(final String challenge, final BufferedImage image) {
        this.challenge = challenge;
        this.image = image;
    }
    
    public String getChallenge() {
        return this.challenge;
    }
    
    public void setChallenge(final String challenge) {
        this.challenge = challenge;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public void setImage(final BufferedImage image) {
        this.image = image;
    }
}
