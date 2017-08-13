import java.util.Arrays;

public class Bird {
    private double x[];
    private double[] best;
    private double v[];

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getBest() {
        return best;
    }

    public void setBest(double[] best) {
        this.best = best;
    }

    public double[] getV() {
        return v;
    }

    public void setV(double[] v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "x=" + Arrays.toString(x) +
                ", best=" + Arrays.toString(best) +
                ", v=" + Arrays.toString(v) +
                '}';
    }
}
