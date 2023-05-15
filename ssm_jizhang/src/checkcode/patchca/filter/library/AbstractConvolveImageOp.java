// 
// 
// 

package checkcode.patchca.filter.library;

public abstract class AbstractConvolveImageOp extends AbstractImageOp
{
    private float[][] matrix;
    
    protected AbstractConvolveImageOp(final float[][] matrix) {
        this.matrix = matrix;
    }
    
    @Override
    protected void filter(final int[] inPixels, final int[] outPixels, final int width, final int height) {
        final long time1 = System.currentTimeMillis();
        final int matrixWidth = this.matrix[0].length;
        final int matrixHeight = this.matrix.length;
        final int mattrixLeft = -matrixWidth / 2;
        final int matrixTop = -matrixHeight / 2;
        for (int y = 0; y < height; ++y) {
            final int ytop = y + matrixTop;
            final int ybottom = y + matrixTop + matrixHeight;
            for (int x = 0; x < width; ++x) {
                final float[] sum = { 0.5f, 0.5f, 0.5f, 0.5f };
                final int xleft = x + mattrixLeft;
                final int xright = x + mattrixLeft + matrixWidth;
                for (int matrixY = 0, my = ytop; my < ybottom; ++my, ++matrixY) {
                    for (int matrixX = 0, mx = xleft; mx < xright; ++mx, ++matrixX) {
                        final int pixel = this.getPixel(inPixels, mx, my, width, height, 0);
                        final float m = this.matrix[matrixY][matrixX];
                        final float[] array = sum;
                        final int n = 0;
                        array[n] += m * (pixel >> 24 & 0xFF);
                        final float[] array2 = sum;
                        final int n2 = 1;
                        array2[n2] += m * (pixel >> 16 & 0xFF);
                        final float[] array3 = sum;
                        final int n3 = 2;
                        array3[n3] += m * (pixel >> 8 & 0xFF);
                        final float[] array4 = sum;
                        final int n4 = 3;
                        array4[n4] += m * (pixel & 0xFF);
                    }
                }
                outPixels[x + y * width] = (this.limitByte((int)sum[0]) << 24 | this.limitByte((int)sum[1]) << 16 | this.limitByte((int)sum[2]) << 8 | this.limitByte((int)sum[3]));
            }
        }
        final long time2 = System.currentTimeMillis() - time1;
    }
}
