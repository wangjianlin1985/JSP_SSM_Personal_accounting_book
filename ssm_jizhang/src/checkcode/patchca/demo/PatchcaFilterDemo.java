// 
// 
// 

package checkcode.patchca.demo;

import java.awt.event.ActionEvent;
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
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Component;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Button;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.Frame;

public class PatchcaFilterDemo extends Frame implements ActionListener
{
    private static final long serialVersionUID = 6698906953413370733L;
    private BufferedImage img;
    private Button reloadButton;
    private int counter;
    
    public PatchcaFilterDemo() {
        super("Patchca demo");
        this.setSize(150, 100);
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (dim.width - this.getSize().width) / 2;
        final int y = (dim.height - this.getSize().height) / 2;
        this.setLocation(x, y);
        final Panel bottom = new Panel();
        (this.reloadButton = new Button("Next filter")).addActionListener(this);
        bottom.add(this.reloadButton);
        this.add("South", bottom);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent we) {
                PatchcaFilterDemo.this.dispose();
            }
        });
    }
    
    @Override
    public void update(final Graphics g) {
        this.paint(g);
    }
    
    @Override
    public void paint(final Graphics g) {
        if (this.img == null) {
            this.createImage();
        }
        if (this.img != null) {
            g.drawImage(this.img, 20, 30, this);
        }
    }
    
    public void createImage() {
        final ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        switch (this.counter % 5) {
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
        this.img = cs.getCaptcha().getImage();
        ++this.counter;
    }
    
    @Override
    public void actionPerformed(final ActionEvent evt) {
        if (evt.getSource() == this.reloadButton) {
            this.createImage();
            this.repaint();
        }
    }
    
    public static void main(final String[] args) {
        final PatchcaFilterDemo f = new PatchcaFilterDemo();
        f.setVisible(true);
    }
}
