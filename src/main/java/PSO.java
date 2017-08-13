import java.util.List;

/**
 * Created by luohao on 2017/8/11.
 */
public class PSO {
    private Function fun;       //适应函数
    private List<Bird> birds;   //粒子群
    private double w;           //惯性权重
    private int gBest;          //群体最优值
    private double c1;
    private double c2;

    public void run() {
        while (true) {
            for (Bird bird : birds) {
                int newVx = (int) (w * bird.getVx() + c1 * Math.random() * (bird.getBest() - bird.getPositionX())
                        + c2 * Math.random() * (gBest - bird.getPositionX()));

                int newPosition = newVx;

                bird.setVx(newPosition);
            }
        }
    }
}
