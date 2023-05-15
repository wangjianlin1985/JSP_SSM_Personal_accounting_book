// 
// 
// 

package com.taoxiuxia.util;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

public class CheckCode
{
    private Random rand;
    
    public CheckCode() {
        this.rand = new Random();
    }
    
    public void generationCheckCode(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setDateHeader("Expires", -1L);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        final int height = 30;
        final int width = 120;
        final int xpyl = 5;
        final int ypyl = 22;
        final int bang = 20;
        final BufferedImage img = new BufferedImage(width, height, 1);
        final Graphics2D g = (Graphics2D)img.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);
        for (int i = 0; i < 5; ++i) {
            g.setColor(Color.red);
            g.drawLine(this.randNum(0, width), this.randNum(0, height), this.randNum(0, width), this.randNum(0, height));
        }
        final String base = "123456789";
        for (int j = 0; j < 4; ++j) {
            g.setColor(new Color(this.randNum(0, 255), this.randNum(0, 255), this.randNum(0, 255)));
            g.setFont(new Font("\u9ed1\u4f53", 1, bang));
            final int r = this.randNum(-45, 45);
            g.rotate(1.0 * r / 180.0 * 3.141592653589793, xpyl + j * 30, ypyl);
            g.drawString(new StringBuilder(String.valueOf(base.charAt(this.randNum(0, base.length() - 1)))).toString(), xpyl + j * 30, ypyl);
            g.rotate(1.0 * -r / 180.0 * 3.141592653589793, xpyl + j * 30, ypyl);
        }
        ImageIO.write(img, "jpg", (OutputStream)response.getOutputStream());
    }
    
    private int randNum(final int begin, final int end) {
        return this.rand.nextInt(end - begin) + begin;
    }
}
