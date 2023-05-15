// 
// 
// 

package checkcode.patchca.filter.library;

public class BlurImageOp extends AbstractConvolveImageOp
{
    private static final float[][] matrix;
    
    static {
        matrix = new float[][] { { 0.0625f, 0.125f, 0.0625f }, { 0.125f, 0.25f, 0.125f }, { 0.0625f, 0.125f, 0.0625f } };
    }
    
    public BlurImageOp() {
        super(BlurImageOp.matrix);
    }
}
