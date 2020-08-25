package leetcode13.algorithm.wk05;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 109. 有序链表转换二叉搜索树
 */
public class Exercise_109 {

    /**
     * 方法一,借助数组获取中点
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // 获取链表长度
        List<ListNode> nodeList = new ArrayList<>();
        ListNode next = head;
        while (next != null) {
            nodeList.add(next);
            next = next.next;
        }

        return toBSF(nodeList, 0, nodeList.size() - 1);
    }

    private TreeNode toBSF(List<ListNode> nodeList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end + 1) / 2;    // 保证偶数时左边多一个
        TreeNode leftNode = toBSF(nodeList, start, mid - 1);
        TreeNode rightNode = toBSF(nodeList, mid + 1, end);
        TreeNode parNode = new TreeNode(nodeList.get(mid).val, leftNode, rightNode);
        return parNode;

    }

    /**
     * 方法二,通过快慢指针获取中点
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST_2(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode start, ListNode end) {
        // 结束条件
        if(start == end) {
            return null;
        }
        // 分成子问题
        ListNode mid = getMedian(start, end);
        TreeNode left = buildTree(start, mid);
        TreeNode right = buildTree(mid.next, end);
        // 合并结果
        return new TreeNode(mid.val, left, right);
    }

    private ListNode getMedian(ListNode start, ListNode end) {
        ListNode slow = start, fast = start;
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
