package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 236. 二叉树的最近公共祖先
 * @author qkh
 *
 */
public class LowestCommonAncestor {

	// 解法一
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 获取 p、 q的所有父节点
		List<TreeNode> pNodes = new ArrayList<>();
		isParentNode(pNodes, root, p);
		List<TreeNode> qNodes = new ArrayList<>();
		isParentNode(qNodes, root, q);
		
		for (TreeNode treeNode : pNodes) {
			if(qNodes.contains(treeNode)) {
				return treeNode;
			}
		}
		return null;
	}
	
	// 解法二,后序遍历
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor2(root.left, p, q);
		TreeNode right = lowestCommonAncestor2(root.right, p, q);
		
		if(left == null) return right;// p,q都在右子树
		
		if(right == null) return left; // p,q都在左子树
		
		return root; // p,q分别在root，左右两边
		
	}
	
	
	private boolean isParentNode(List<TreeNode> parentNodes ,TreeNode parent, TreeNode child) {
		if(child == parent) {
			parentNodes.add(parent);
			return true;
		}
		if(parent == null) {
			return false;
		}
		if(isParentNode(parentNodes,parent.left,child)) {
			parentNodes.add(parent);
			return true;
		}
		if(isParentNode(parentNodes,parent.right,child)) {
			parentNodes.add(parent);
			return true;
		}
		return false;
	}
}

