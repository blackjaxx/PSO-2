import java.util.Arrays;

/**
 * Created by luohao on 2017/8/11.
 */
public class Main2 {
    private static int aim = 35498;

    public static void main(String[] args) {
        double[] result = {92.0, 34.0, -36.0, 32.0, 27.0, 18.0, 19.0, -14.0, -14.0, 23.0};
        double sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum+=(i+1)*result[i]*result[i];
        }
        System.out.println(sum);
        //int[] xs = new int[10];
        //place(xs, 0);
    }

    public static void place(int[] xs, int index) {
        if (index == 10) {
            if (f(xs) == aim) {
                System.out.println(Arrays.toString(xs));
            }else {
                System.out.println("NOT:"+Arrays.toString(xs));
            }
            return;
        }
        int max = (int) Math.sqrt(aim / 10);
        for (int i = 1; i < max; i++) {
            xs[index] = i;
            if (cut(xs)) {
                place(xs, index + 1);
            }
        }
    }

    public static boolean cut(int[] xs) {
        for (int i = 0; i < xs.length - 1; i++) {
            if ( xs[i] != 0 && xs[i + 1] != 0 && xs[i] > xs[i + 1]) {
                return false;
            }
        }
        if (f(xs) > aim) {
            return false;
        }
        return true;
    }

    public static int f(int[] xs) {
        int sum = 0;
        for (int i = 0; i < xs.length; i++) {
            sum += (i + 1) * i * i;
        }
        return sum;
    }

}
