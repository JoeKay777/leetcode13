package leetcode13.algorithm.wk04;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 * 
 * @author qkh
 *
 */
public class SolveNQueens {

	private int size = 0;

	public List<List<String>> solveNQueens(int n) {
		this.size = n;
		backtrack(0, new ArrayList<>(n));
		return result;
	}

	private List<List<String>> result = new ArrayList<>();

	private void backtrack(int level, List<Integer> yList) { //  yList 值存放y坐标，下标为横坐标
		if (level == size) {
			List<String> list = new ArrayList<>(size);
			for (Integer y : yList) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < size; i++) {
					if (i == y) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				list.add(sb.toString());
			}
			result.add(list);
		}

		restart: for (int i = 0; i < size; i++) {
			
			// 剪枝
			for (int x = 0; x < level; x++) {
				int y = yList.get(x);
				// y相同
				// 在同一右斜线 x-y相同
				// 在同一左斜线 x+y相同
				if (i == y || level + i == x + y || level - i == x - y) {
					continue restart;
				}
			}
			// 选择
			yList.add(i);
			// 回溯
			backtrack(level + 1, yList);
			// 撤销选择
			yList.remove(yList.size() - 1);
		}
	}

	public static void main(String[] args) {
		new SolveNQueens().solveNQueens(4);
	}
}
