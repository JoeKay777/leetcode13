package leetcode13.algorithm.wk06;

/**
 * 70. 爬楼梯
 */
public class Exercise_70 {
    public int climbStairs(int n) {
        if(n < 3) {
            return n;
        }
        int a1 = 1, a2 = 2, an = a2;
        for(int i = 3; i <= n; i++) {
            an = a1 + a2;
            a1 = a2;
            a2 = an;
        }
        return an;
    }
}
