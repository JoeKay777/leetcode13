package leetcode13.algorithm.wk08;

/**
 * 191. 位1的个数
 */
public class Exercise_191 {
    /**
     * 位运算，最优
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
