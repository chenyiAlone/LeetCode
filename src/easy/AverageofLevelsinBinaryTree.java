package easy;

import java.util.*;
import util.*;


/**
 * ClassName: AverageofLevelsinBinaryTree.java
 * Author: chenyiAlone
 * Create Time: 2019/10/10 21:30
 * Description: No.637 Average of Levels in Binary Tree
 */
public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ret.add(sum / size);
        }
        return ret;
    }
    
}