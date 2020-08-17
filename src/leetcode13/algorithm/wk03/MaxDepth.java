package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.List;

/**
 * 104. 二叉树的最大深度
 * @author qkh
 *
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth( root.right)) + 1;
    }
	
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
