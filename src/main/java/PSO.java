import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luohao on 2017/8/11.
 */
public class PSO {
    private Function fun;       //适应函数
    private List<Bird> birds;   //粒子群
    private double w = 0.8;           //惯性权重
    private double[] gBest;          //群体最优值
    private double c1 = 2;
    private double c2 = 2;

    public static void main(String[] args) {
        PSO pso = new PSO();
        pso.setFun(new Function() {
            public double f(double[] xs) {
                return Math.abs(1313 - xs[0] * xs[0] - xs[1] * xs[1]);
            }
        });
        List<Bird> birds = createBird(2, 1, 50, 1, 5, pso.getFun(), 5, pso);
        pso.setBirds(birds);
        for (Bird bird : birds) {
            System.out.println(bird);
        }
        System.out.println(Arrays.toString(pso.getgBest()));

        pso.run(0.5);
    }

    public static List<Bird> createBird(int xlen, int xmin, int xmax, int vmin, int vmax, Function fun, int birdsLen, PSO pso) {
        List<Bird> birds = new ArrayList<Bird>();
        double[] gBest = null;
        for (double i = 0; i < birdsLen; i++) {
            Bird bird = new Bird();
            double[] x = new double[xlen];
            for (int j = 0; j < x.length; j++) {
                x[j] =  (int)(Math.random() * (xmax - xmin)) + xmin;
            }
            bird.setX(x);
            bird.setBest(x);
            double[] v = new double[xlen];
            for (int j = 0; j < v.length; j++) {
                v[j] = (Math.random() * (vmax - vmin)) + vmin;
            }
            if (gBest == null || fun.f(x) < fun.f(gBest)) {
                gBest = x;
            }
            bird.setV(v);
            birds.add(bird);
        }
        pso.setgBest(gBest);
        return birds;
    }

    public void run(double aim) {
        int count = 0;
        while (true) {
            count++;
//            for (Bird bird : birds) {
//                System.out.println(bird);
//            }
            System.out.println(Arrays.toString(gBest) + ":" + fun.f(gBest));
            for (Bird bird : birds) {
                double[] v = bird.getV();
                double[] x = bird.getX();
                double[] pBest = bird.getBest();
                double oldValue = fun.f(x);
                double rand1 = Math.random();
                double rand2 = Math.random();
                for (int i = 0; i < v.length; i++) {
                    v[i] = (w * v[i] + c1 * rand1 * (pBest[i] - x[i]) + c2 * rand2 * (gBest[i] - x[i]));
                    x[i] = (int)(x[i]+v[i]);
                }
                bird.setX(x);
                double newValue = fun.f(x);
                if (newValue < oldValue) {
                    bird.setBest(copy(x));
                }
                if (newValue < fun.f(gBest)) {
                    gBest = copy(x);
                }
            }
            if(fun.f(gBest)<aim){
                break;
            }
        }
        System.out.println(Arrays.toString(gBest)+":::::"+fun.f(gBest));
        System.out.println(count);
    }

    public static double[] copy(double[] old) {
        if (old == null) {
            return null;
        }
        double[] result = new double[old.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = old[i];
        }
        return result;
    }

    public Function getFun() {
        return fun;
    }

    public void setFun(Function fun) {
        this.fun = fun;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double[] getgBest() {
        return gBest;
    }

    public void setgBest(double[] gBest) {
        this.gBest = gBest;
    }

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }
}
