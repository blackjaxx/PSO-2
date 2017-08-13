import java.util.Arrays;

/**
 * Created by luohao on 2017/8/13.
 */
public class Main3 {
    private static int aim = 200;

    public static void main(String[] args) {
        int[] arr = new int[6];//首先使用一个三维数组表示一个解
        place(arr, 0);
    }

    public static void place(int[] arr, int index) {//place方法循环设置每天位的值
        if (index == arr.length) {
            int sum = arr[0]+arr[1]*5+arr[2]*10+arr[3]*20+arr[4]*50+arr[5]*100;
            if (sum == aim) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = 0; i < aim; i++) {
            arr[index] = i;
            if (check(arr)) {
                place(arr, index+1);
            }
        }
    }

    public static boolean check(int[] arr) {//剪枝函数剪去不合要求的数组
        int sum = arr[0]+arr[1]*5+arr[2]*10+arr[3]*20+arr[4]*50+arr[5]*100;
        return sum<=aim;
    }
}
