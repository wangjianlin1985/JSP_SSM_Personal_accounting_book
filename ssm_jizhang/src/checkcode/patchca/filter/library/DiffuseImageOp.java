// 
// 
// 

package checkcode.patchca.filter.library;

import java.util.Random;

public class DiffuseImageOp extends AbstractTransformImageOp
{
    double[] tx;
    double[] ty;
    double amount;
    
    public DiffuseImageOp() {
        this.amount = 1.6;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(final double amount) {
        this.amount = amount;
    }
    
    @Override
    protected synchronized void init() {
        this.tx = new double[256];
        this.ty = new double[256];
        for (int i = 0; i < 256; ++i) {
            final double angle = 6.283185307179586 * i / 256.0;
            this.tx[i] = this.amount * Math.sin(angle);
            this.ty[i] = this.amount * Math.cos(angle);
        }
    }
    
    @Override
    protected void transform(final int x, final int y, final double[] t) {
        final Random r = new Random();
        final int angle = (int)(r.nextFloat() * 255.0f);
        t[0] = x + this.tx[angle];
        t[1] = y + this.ty[angle];
    }
}
