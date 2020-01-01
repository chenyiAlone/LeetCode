package easy;

import java.util.*;
import util.*;

/**
 * ClassName: AllElementsinTwoBinarySearchTrees.java
 * Author: chenyiAlone
 * Create Time: 2020/1/1 21:14 
 * Description: No.1305 All Elements in Two Binary Search Trees
 */
public class AllElementsinTwoBinarySearchTrees {

    private List<Integer> ret = new LinkedList<>();

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ret.add(root.val);
        dfs(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(ret);
        return ret;
    }

}