package leetcode13.algorithm.wk03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * @author qkh
 *
 */
public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur == null) {
				sb.append((String)null).append(",");
				continue;
			}
			sb.append(cur.val).append(",");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
//		System.out.println(sb);
		return sb.substring(0, sb.length() -1).toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null) {
			return null;
		}
		String[] split = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(split[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int i = 1;
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur == null) {
				continue;
			}
			if(i < split.length) {
				cur.left = createTreeNode(split[i++]);
				queue.offer(cur.left);
			}
			if(i < split.length) {
				cur.right = createTreeNode(split[i++]);
				queue.offer(cur.right);
			}
		}
		return root;
	}
	
	private TreeNode createTreeNode(String value) {
		if(value.equals("null")) {
			return null;
		}else {
			return new TreeNode(Integer.parseInt(value));
		}
	}
}
