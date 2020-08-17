package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @author qkh
 *
 */
public class LowestCommonAncestor2 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		if(root.val > p.val && root.val > q.val) {	// 都在左
			return lowestCommonAncestor(root.left, p, q);
		}
		if(root.val < p.val && root.val < q.val) { // 都在右
			return lowestCommonAncestor(root.right, p, q);
		}
		// 分别在左右
		return root;
	}
	
	
}

