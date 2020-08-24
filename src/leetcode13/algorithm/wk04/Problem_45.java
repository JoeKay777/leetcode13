package leetcode13.algorithm.wk04;

/**
 * 45. 跳跃游戏 II
 */
public class Problem_45 {



    public int jump(int[] nums) {
        int curIndex = nums[0];       // 当前能达到的最大距离
        int stepCount = 0;          // 跳跃次数统计
        int stepIndex = 0;       // 上一步所能到达的最远距离
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(stepCount >= end) {
                break;
            }
            int nextIndex = nums[i] + i;
            if(i > stepIndex) {  // 当前位置大于了上一步所能到达的最远距离，则增加一步
                stepCount++;
                stepIndex = curIndex;
            }
            if (nextIndex > curIndex) { // 记录当前最大距离
                curIndex = nextIndex;
            }
        }
        return stepCount;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int jump = new Problem_45().jump(new int[]{2,3,1,1,4});
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(jump);
    }
}
