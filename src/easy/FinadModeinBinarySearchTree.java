package easy;

import java.util.*;
import util.*;
/**
 * ClassName: FinadModeinBinarySearchTree.java
 * Author: chenyiAlone
 * Create Time: 2019/9/6 7:40
 * Description: No.501 Find a Mode in Binary Search Tree
 * 思路:
 *      1. 中序遍历数组
 *      2. cur != pre 的时候，更新 pre
 *
 *          1) 如果 pre 的值
 *
 *
 */
public class FinadModeinBinarySearchTree {

    
    public int[] findMode(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int cnt = 0, maxCnt = 0, pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int v = cur.val;
            cur = cur.right;

            if (pre == v) {
                cnt++;
            } else {
                if (cnt > maxCnt) {
                    ans.clear();
                    maxCnt = cnt;
                }
                if (cnt == maxCnt && maxCnt != 0) {
                    ans.add(pre);
                }
                cnt = 1;
                pre = v;
            }
        }
        if (cnt > maxCnt) {
            ans.clear();
            maxCnt = cnt;
        }
        if (cnt == maxCnt && maxCnt != 0) ans.add(pre);
        int[] ret = new int[ans.size()];
        int i = 0;
        for (Iterator<Integer> iter = ans.iterator(); iter.hasNext(); i++) ret[i] = iter.next();
        return ret;
    }
}