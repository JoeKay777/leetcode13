package leetcode13.algorithm.wk03;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 
 * @author qkh
 *
 */
public class MinDepth {
	
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int ld = minDepth(root.left);
		int rd = minDepth(root.right);
		if(root.right == null || root.left == null) return ld + rd + 1;
		return Math.min(ld, rd) + 1;
	}
	
	/**
	 * 广度优先遍历
	 * @param root
	 * @return
	 */
	public int minDepth2(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		if(root == null) {
			return 0;
		}
		queue.add(root);
		Map<TreeNode, Integer> depthMap = new HashMap<>();
		depthMap.put(root,1);
		int depth = 1;
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			depth = depthMap.get(cur);
			if(cur.left == null && cur.right == null) {	// 左右节点为空，则该节点即为最小深度节点
				return depth;
			}
			if(cur.left != null) {
				depthMap.put(cur.left, depth+1);
				queue.offer(cur.left);
			}
			if(cur.right != null) {
				depthMap.put(cur.right, depth+1);
				queue.offer(cur.right);
			}
		}
		return depth ;
	}
	
	
	
}
