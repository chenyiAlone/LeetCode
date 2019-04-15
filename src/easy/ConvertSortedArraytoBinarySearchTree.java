package easy;

import util.TreeNode;
/**
 * 
 * ClassName: ConvertSortedArraytoBinarySearchTree
 * @author chenyiAlone  
 * Create Time: 2019/04/15 17:21:53
 * Description: No.108
 * 思路:
 *     1. nums 是有序的，只需要找到中间坐标 mid 的值，就是根节点
 *     2. dfs(lb, rb, nums); 关于边界， lb 和 rb 不变，只要有了 if (lb > rb) return; 就用担心出界的问题
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    
    Example:
    
    Given the sorted array: [-10,-3,0,5,9],
    
    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
    
          0
         / \
       -3   9
       /   /
     -10  5
 * 
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }
    private TreeNode dfs(int lb, int rb, int[] nums) {
        if (lb > rb)
            return null;
        int mid = (lb + rb) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(lb, mid - 1, nums);
        root.right = dfs(mid + 1, rb, nums);
        return root;
    }
}