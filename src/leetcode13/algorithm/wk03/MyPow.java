package leetcode13.algorithm.wk03;

/**
 * 50. Pow(x, n)
 */
public class MyPow {
    /**
     * 分治法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1.0;
        }
        if(n < 0) {
            x = 1/x;
        }
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }

    public static void main(String[] args) {
        new MyPow().myPow(2.0000, -3);
    }

}