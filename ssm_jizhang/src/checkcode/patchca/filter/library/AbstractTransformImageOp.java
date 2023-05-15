// 
// 
// 

package checkcode.patchca.filter.library;

public abstract class AbstractTransformImageOp extends AbstractImageOp
{
    private boolean initialized;
    
    protected abstract void transform(final int p0, final int p1, final double[] p2);
    
    protected void init() {
    }
    
    public AbstractTransformImageOp() {
        this.setEdgeMode(2);
    }
    
    @Override
    protected void filter(final int[] inPixels, final int[] outPixels, final int width, final int height) {
        if (!this.initialized) {
            this.init();
            this.initialized = true;
        }
        final long time1 = System.currentTimeMillis();
        final double[] t = new double[2];
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                this.transform(x, y, t);
                final int pixel = this.getPixelBilinear(inPixels, t[0], t[1], width, height, this.getEdgeMode());
                outPixels[x + y * width] = pixel;
            }
        }
        final long time2 = System.currentTimeMillis() - time1;
    }
}
