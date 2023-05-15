// 
// 
// 

package checkcode.patchca.filter.library;

public class MarbleImageOp extends AbstractTransformImageOp
{
    double scale;
    double amount;
    double turbulence;
    double[] tx;
    double[] ty;
    double randomX;
    double randomY;
    
    public MarbleImageOp() {
        this.scale = 15.0;
        this.amount = 1.1;
        this.turbulence = 6.2;
        this.randomX = 256.0 * Math.random();
        this.randomY = 256.0 * Math.random();
    }
    
    public double getScale() {
        return this.scale;
    }
    
    public void setScale(final double scale) {
        this.scale = scale;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(final double amount) {
        this.amount = amount;
    }
    
    public double getTurbulence() {
        return this.turbulence;
    }
    
    public void setTurbulence(final double turbulence) {
        this.turbulence = turbulence;
    }
    
    @Override
    protected synchronized void init() {
        this.tx = new double[256];
        this.ty = new double[256];
        for (int i = 0; i < 256; ++i) {
            final double angle = 6.283185307179586 * i * this.turbulence / 256.0;
            this.tx[i] = this.amount * Math.sin(angle);
            this.ty[i] = this.amount * Math.cos(angle);
        }
    }
    
    @Override
    protected void transform(final int x, final int y, final double[] t) {
        final int d = this.limitByte((int)(127.0 * (1.0 + PerlinNoise.noise2D(x / this.scale + this.randomX, y / this.scale + this.randomY))));
        t[0] = x + this.tx[d];
        t[1] = y + this.ty[d];
    }
    
    protected void filter2(final int[] inPixels, final int[] outPixels, final int width, final int height) {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                final int pixel = this.limitByte((int)(127.0 * (1.0 + PerlinNoise.noise2D(x / this.scale + this.randomX, y / this.scale + this.randomY))));
                outPixels[x + y * width] = (this.limitByte(255) << 24 | this.limitByte(pixel) << 16 | this.limitByte(pixel) << 8 | this.limitByte(pixel));
            }
        }
    }
}
