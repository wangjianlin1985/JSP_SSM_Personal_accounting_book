// 
// 
// 

package checkcode.patchca.filter.library;

public class WobbleImageOp extends AbstractTransformImageOp
{
    private double xWavelength;
    private double yWavelength;
    private double xAmplitude;
    private double yAmplitude;
    private double xRandom;
    private double yRandom;
    private double xScale;
    private double yScale;
    
    public WobbleImageOp() {
        this.xWavelength = 15.0;
        this.yWavelength = 15.0;
        this.xAmplitude = 4.0;
        this.yAmplitude = 3.0;
        this.xScale = 1.0;
        this.yScale = 1.0;
        this.xRandom = 3.0 * Math.random();
        this.yRandom = 10.0 * Math.random();
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
    
    public double getxScale() {
        return this.xScale;
    }
    
    public void setxScale(final double xScale) {
        this.xScale = xScale;
    }
    
    public double getyScale() {
        return this.yScale;
    }
    
    public void setyScale(final double yScale) {
        this.yScale = yScale;
    }
    
    @Override
    protected void transform(final int x, final int y, final double[] t) {
        final double tx = Math.cos((this.xScale * x + y) / this.xWavelength + this.xRandom);
        final double ty = Math.sin((this.yScale * y + x) / this.yWavelength + this.yRandom);
        t[0] = x + this.xAmplitude * tx;
        t[1] = y + this.yAmplitude * ty;
    }
}
