package medium;

import util.*;

/**
 * ClassName: ConvertSortedListtoBinarySearchTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/21 19:38
 * Description: No.109 Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class ConvertSortedListtoBinarySearchTree {

    private int size;
    private ListNode[] arr;
    private int index;
    public TreeNode dfs(int l, int r) {
        TreeNode ret = l == r ? new TreeNode(arr[l].val) : null;
        if (l >= r) return ret;
        int mid = (l + r) / 2;
        ret = new TreeNode(arr[mid].val);
        ret.left = dfs(l, mid - 1);
        ret.right = dfs(mid + 1, r);
        return ret;
    }

    public TreeNode sortedListToBST(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next)
            size++;
        arr = new ListNode[size];
        for (int i = 0; i < size; i++, head = head.next) arr[i] = head;
        return dfs(0, size - 1);
    }

}