// 
// 
// 

package checkcode.patchca.filter.library;

public class SoftenImageOp extends AbstractConvolveImageOp
{
    private static final float[][] matrix;
    
    static {
        matrix = new float[][] { { 0.0f, 0.0625f, 0.0f }, { 0.0625f, 0.75f, 0.0625f }, { 0.0f, 0.0625f, 0.0f } };
    }
    
    public SoftenImageOp() {
        super(SoftenImageOp.matrix);
    }
}
