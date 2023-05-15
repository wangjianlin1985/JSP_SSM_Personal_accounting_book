// 
// 
// 

package checkcode.patchca.filter.library;

public class RippleImageOp extends AbstractTransformImageOp
{
    protected double xWavelength;
    protected double yWavelength;
    protected double xAmplitude;
    protected double yAmplitude;
    protected double xRandom;
    protected double yRandom;
    
    public RippleImageOp() {
        this.xWavelength = 20.0;
        this.yWavelength = 10.0;
        this.xAmplitude = 5.0;
        this.yAmplitude = 5.0;
        this.xRandom = 5.0 * Math.random();
        this.yRandom = 5.0 * Math.random();
    }
    
    public double getxWavelength() {
        return this.xWavelength;
    }
    
    public void setxWavelength(final double xWavelength) {
        this.xWavelength = xWavelength;
    }
    
    public double getyWavelength() {
        return this.yWavelength;
    }
    
    public void setyWavelength(final double yWavelength) {
        this.yWavelength = yWavelength;
    }
    
    public double getxAmplitude() {
        return this.xAmplitude;
    }
    
    public void setxAmplitude(final double xAmplitude) {
        this.xAmplitude = xAmplitude;
    }
    
    public double getyAmplitude() {
        return this.yAmplitude;
    }
    
    public void setyAmplitude(final double yAmplitude) {
        this.yAmplitude = yAmplitude;
    }
    
    @Override
    protected void transform(final int x, final int y, final double[] t) {
        final double tx = Math.sin(y / this.yWavelength + this.yRandom);
        final double ty = Math.cos(x / this.xWavelength + this.xRandom);
        t[0] = x + this.xAmplitude * tx;
        t[1] = y + this.yAmplitude * ty;
    }
}
