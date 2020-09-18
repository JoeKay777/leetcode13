package leetcode13.algorithm.wk08;

/**
 * 338. 比特位计数
 */
public class Exercise_338 {

    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        res[0] = 0;
        int n = 1;
        while (n <= num) {
            if ((n & 1) == 0) { // 偶数的1与它的1/2的数一样多
                res[n] = res[n >> 1];
            } else {    // 比前面的偶数多1
                res[n] = res[n -1] + 1;
            }
            n++;
        }
        return res;
    }

    /**
     * 统计整数二进制中1的个数
     *
     * @param n
     * @return
     */
    private int countBitHelp(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
