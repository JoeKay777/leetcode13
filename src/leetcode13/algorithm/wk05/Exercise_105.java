package leetcode13.algorithm.wk05;

import java.util.HashMap;
import java.util.Map;

/**
 * 105.从前序与中序遍历序列构造二叉树
 */
public class Exercise_105 {

    private Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length -1 , 0, inorder.length -1);
    }

    private TreeNode build(int[] preorder, int pre_start, int pre_end, int in_start , int in_end) {
        // 终止条件
        if(pre_start > pre_end) {
            return null;
        }
        // 分治
        int rootValue = preorder[pre_start];
        TreeNode root = new TreeNode(rootValue);
        Integer root_idx = inMap.get(rootValue);
        int left_size = root_idx - in_start;
        root.left = build(preorder, pre_start + 1, pre_start + left_size, in_start, in_start + left_size );
        root.right = build(preorder, pre_start + left_size + 1, pre_end, root_idx + 1, in_end);
        // 返回结果
        return root;
    }
}
