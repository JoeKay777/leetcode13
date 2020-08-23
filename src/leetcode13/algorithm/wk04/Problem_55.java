package leetcode13.algorithm.wk04;

/**
 * 55.跳跃游戏
 */
public class Problem_55 {
    public boolean canJump(int[] nums) {
        // 下标+值是一个位置能到达的最大位置
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        new Problem_55().canJump(new int[] {3,2,1,0,4});
    }
}
