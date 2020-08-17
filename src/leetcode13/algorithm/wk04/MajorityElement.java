package leetcode13.algorithm.wk04;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 */
public class MajorityElement {
	/**
	 * 摩尔投票法思路
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int temp = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == temp) {
				count++;
			} else {
				count--;
				if (count == 0) {
					temp = nums[i];
					count = 1;
				}
			}
		}
		return temp;
	}

	/**
	 * 哈希解法
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int res = nums[0];
		for (int num : nums) {
			Integer count = numMap.getOrDefault(num, 0);
			count++;
			if(count > nums.length / 2) {
				return num;
			}
			numMap.put(num, count);
		}
		return res;
	}

}
