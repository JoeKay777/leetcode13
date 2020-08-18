package leetcode13.algorithm.wk04;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 */
public class LevelOrder {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {

            int size = queue.size();    // 当前层的元素数量
            List<Integer> list = new ArrayList<>(size);
            while (size > 0) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                size--;
                TreeNode left = curNode.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = curNode.right;
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
