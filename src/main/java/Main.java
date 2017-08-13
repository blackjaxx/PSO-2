import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by luohao on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Set<Result> results = f(16);
        for (Result result : results) {
            System.out.println(result);

        }
    }

    public static Set<Result> f(int x) {
        Set<Result> results = new HashSet<Result>();
        if (x <= 0) {
            return Collections.emptySet();
        }
        if (x == 1) {
            Result result1 = new Result();
            result1.setCount1(1);
            results.add(result1);
            return results;
        }
        int[] rm = {1, 5, 10, 20, 50, 100};
        for (int i : rm) {
            Set<Result> oldResults = f(x - i);
            for (Result result : oldResults) {
                Result newResult = copy(result);
                newResult.setCount(i, newResult.getCount(i) + 1);
                results.add(newResult);
            }
        }
        return results;
    }

    public static Result copy(Result result) {
        if (result == null) {
            return null;
        }
        Result newResult = new Result();
        newResult.setCount1(result.getCount1());
        newResult.setCount5(result.getCount5());
        newResult.setCount10(result.getCount10());
        newResult.setCount20(result.getCount20());
        newResult.setCount50(result.getCount50());
        newResult.setCount100(result.getCount100());
        return newResult;
    }
}

/**
 * 用一个对象来表示一个结果
 */
class Result {
    private int count1;
    private int count5;
    private int count10;
    private int count20;
    private int count50;
    private int count100;

    public void setCount(int i, int newCount) {
        if (i == 1) {
            setCount1(newCount);
        } else if (i == 5) {
            setCount5(newCount);
        } else if (i == 10) {
            setCount10(newCount);
        } else if (i == 20) {
            setCount20(newCount);
        } else if (i == 50) {
            setCount50(newCount);
        } else if (i == 100) {
            setCount100(newCount);
        }
    }

    public int getCount(int i) {
        if (i == 1) {
            return getCount1();
        } else if (i == 5) {
            return getCount5();
        } else if (i == 10) {
            return getCount10();
        } else if (i == 20) {
            return getCount20();
        } else if (i == 50) {
            return getCount50();
        } else if (i == 100) {
            return getCount100();
        }
        return 0;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount5() {
        return count5;
    }

    public void setCount5(int count5) {
        this.count5 = count5;
    }

    public int getCount10() {
        return count10;
    }

    public void setCount10(int count10) {
        this.count10 = count10;
    }

    public int getCount20() {
        return count20;
    }

    public void setCount20(int count20) {
        this.count20 = count20;
    }

    public int getCount50() {
        return count50;
    }

    public void setCount50(int count50) {
        this.count50 = count50;
    }

    public int getCount100() {
        return count100;
    }

    public void setCount100(int count100) {
        this.count100 = count100;
    }

    @Override
    public String toString() {
        return "[" + count1 + "," + count5 + "," + count10 + "," + count20 + "," + count50 + "," + count100 + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (count1 != result.count1) return false;
        if (count5 != result.count5) return false;
        if (count10 != result.count10) return false;
        if (count20 != result.count20) return false;
        if (count50 != result.count50) return false;
        return count100 == result.count100;
    }

    @Override
    public int hashCode() {
        int result = count1;
        result = 31 * result + count5;
        result = 31 * result + count10;
        result = 31 * result + count20;
        result = 31 * result + count50;
        result = 31 * result + count100;
        return result;
    }
}
