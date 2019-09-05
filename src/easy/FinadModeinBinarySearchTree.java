package easy;

import java.util.*;

public class FinadModeinBinarySearchTree {

    
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<Integer> ans = new LinkedList<>();
        int cnt = 0, maxCnt = 0, pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                int v = cur.val;
                cur = cur.right;
                //System.out.println(v);
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
        }
        if (cnt > maxCnt) {
            ans.clear();
            maxCnt = cnt;
        }
        if (cnt == maxCnt && cnt != 0) ans.add(pre);
        int[] ret = new int[ans.size()];
        int i = 0;
        for (int x : ans) ret[i++] = x;  
        return ret;
    }
}