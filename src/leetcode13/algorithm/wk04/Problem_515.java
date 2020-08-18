package leetcode13.algorithm.wk04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 */
public class Problem_515 {

    //     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            int max = queue.peek().val;
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.val > max) {
                    max = cur.val;
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        dfs(0, root);
        return result;
    }
    List<Integer> result = new ArrayList<>();
    private void dfs(int level, TreeNode node) {
        if(node == null) {
            return;
        }
        if(level == result.size()) {
            result.add(node.val);
        }else if(result.get(level) < node.val) {
            result.set(level, node.val);
        }
        dfs(level + 1, node.left);
        dfs(level + 1, node.right);
    }
}
