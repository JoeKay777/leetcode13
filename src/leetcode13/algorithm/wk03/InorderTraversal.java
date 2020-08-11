package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * 94. 二叉树的中序遍历
 * 非递归解法
 * @author qkh
 *
 */
public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			while(cur!= null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}
	
	public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		root.right = node2;
		node2.left = new TreeNode(3);
		
		System.out.println(Arrays.toString(new InorderTraversal().inorderTraversal(root).toArray()));
		
	}
}

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
