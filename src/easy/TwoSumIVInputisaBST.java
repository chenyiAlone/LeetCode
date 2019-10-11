package easy;

import java.util.*;
import util.*;

/**
 * ClassName: TwoSumIVInputinaBST.java
 * Author: chenyiAlone
 * Create Time: 2019/10/11 20:14
 * Description: No.653 Two Sum IV - Input is a BST
 */
public class TwoSumIVInputinaBST {

    private Set<Integer> set = new HashSet<>(); 
    
    
    public boolean findTarget(TreeNode root, int k) {
        boolean ret = false;
        if (root == null) return ret;
        
        ret |= findTarget(root.left, k);
        if (set.contains(k - root.val)) ret = true;
        set.add(root.val);
        ret |= findTarget(root.right, k);
        return ret;
    }
}