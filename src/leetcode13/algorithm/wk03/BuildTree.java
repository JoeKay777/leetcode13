package leetcode13.algorithm.wk03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inMap, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int pre_start, int pre_size, Map<Integer, Integer> inMap, int in_start, int in_len) {
        if (pre_size == 0) {
            return null;
        }
        int rootValue = preorder[pre_start];
        TreeNode root = new TreeNode(rootValue);
        // 在中序遍历中，根节点的前边节点为左子树，右边为右子树
        int rootIdx = inMap.get(rootValue);
        int size = rootIdx - in_start;
        root.left = build(preorder, pre_start + 1, size, inMap, in_start, size);
        root.right = build(preorder, pre_start + 1 + size, pre_size - size - 1, inMap, rootIdx + 1, in_len - size - 1);
        return root;
    }


}
