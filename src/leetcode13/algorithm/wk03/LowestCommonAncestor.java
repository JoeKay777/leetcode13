package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * @author qkh
 *
 */
public class LowestCommonAncestor {

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

