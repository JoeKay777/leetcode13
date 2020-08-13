package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/**
 * 589. N叉树的前序遍历
 * 非递归解法
 * @author qkh
 *
 */
public class Preorder {
	public List<Integer> preorder(Node root) {
		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		stack.add(root);
		Node cur = root;
		while(!stack.isEmpty()) {
			cur = stack.pop();
			list.add(cur.val);
			
			List<Node> children = cur.children;
			if(children != null) {
				for(int i = children.size() -1; i >= 0 ; i--) {
					stack.push(children.get(i));
				}
			}
		}
		return list;
	}
	
}

//Definition for a Node.
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};
