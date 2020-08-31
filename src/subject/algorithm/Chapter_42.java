package subject.algorithm;

/**
 * 我们有一个数字序列包含 n 个不同的数字，
 * 如何求出这个序列中的最长递增子序列长度？
 * 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，
 * 它的最长递增子序列就是 2, 3, 5, 7，
 * 所以最长递增子序列的长度是 4。
 */
public class Chapter_42 {

    public int longestSubSequence(int[] nums) {
        int longest = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int longth = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    longth = Math.max(dp[j], longth);
                }
            }
            dp[i] = longth + 1;

            longest = Math.max(dp[i], longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        int longth = new Chapter_42().longestSubSequence(new int[]{2, 9, 3, 6, 5, 1, 7});
        System.out.println(longth);
    }
}
