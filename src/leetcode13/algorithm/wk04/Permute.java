package leetcode13.algorithm.wk04;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 
 * @author qkh
 *
 */
public class Permute {

	public List<List<Integer>> permute(int[] nums) {
		this.nums = nums;
		backtrack(0, new ArrayList<>(nums.length));
		return result;
	}

	private List<List<Integer>> result = new ArrayList<>();
	private int[] nums = null;

	private void backtrack(int first, List<Integer> list) {
		if (first == nums.length) {
			result.add(new ArrayList<>(list));
		}

		for (int i = first; i < nums.length; i++) {
			
			// 将要添加的元素与first交换，避免重复
			int temp = nums[first];
			nums[first] = nums[i];
			nums[i] = temp;
			// 选择
			list.add(nums[first]);
			// 回溯
			backtrack(first + 1, list);
			
			// 撤销
			int temp2 = nums[first];
			nums[first] = nums[i];
			nums[i] = temp2;
			list.remove(list.size() - 1);
		}
	}
	
}
