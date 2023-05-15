// 
// 
// 

package checkcode.patchca.filter.library;

public class DoubleRippleImageOp extends RippleImageOp
{
    @Override
    protected void transform(final int x, final int y, final double[] t) {
        final double tx = Math.sin(y / this.yWavelength + this.yRandom) + 1.3 * Math.sin(0.6 * y / this.yWavelength + this.yRandom);
        final double ty = Math.cos(x / this.xWavelength + this.xRandom) + 1.3 * Math.cos(0.6 * x / this.xWavelength + this.xRandom);
        t[0] = x + this.xAmplitude * tx;
        t[1] = y + this.yAmplitude * ty;
    }
}
