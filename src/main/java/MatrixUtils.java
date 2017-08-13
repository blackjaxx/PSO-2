/**
 * Created by llhao on 2017/8/13.
 */
public class MatrixUtils {
    public static int[] muti(int[] base, double p) {
        for (int i = 0; i < base.length; i++) {
            base[i] = (int) p * base[i];
        }
        return base;
    }

    public static int[] muti(int[] base, int[] base2) {
        if (base.length != base2.length) {
            throw new RuntimeException("两向量维度不相同");
        }
        int[] result = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            result[i] = base2[i] * base[i];
        }
        return result;
    }

    public static int[] reduce(int[] base, int[] base2){
        if (base.length != base2.length) {
            throw new RuntimeException("两向量维度不相同");
        }
        int[] result = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            result[i] = base[i] - base2[i];
        }
        return result;
    }
}
