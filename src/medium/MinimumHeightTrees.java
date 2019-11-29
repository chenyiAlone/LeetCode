package medium;

import java.util.*;


/**
 * ClassName: MinimumHeightTrees.java
 * Author: chenyiAlone
 * Create Time: 2019/11/29 22:33 
 * Description: No.310 Minimum Height Trees
 */
public class MinimumHeightTrees {


    private List<List<Integer>> graph;
    private int[] hights;
    private int maxH = Integer.MAX_VALUE;
    
    
    private void dfs(int root, int cur, int parent, int depth) {
        hights[root] = Math.max(hights[root], depth);
        if (hights[root] > maxH) return;
        for (int next : graph.get(cur)) {
            if (next != parent) dfs(root, next, cur, depth + 1);
        }
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new ArrayList<>(n);
        hights = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(i, i, -1, 1);
            maxH = Math.min(maxH, hights[i]);
        }
        Stack<Integer> ret = new Stack<>();
        for (int i = 0; i < n; i++) {
          //  System.out.print(hights[i] + " ");
            if (ret.isEmpty() || hights[i] == hights[ret.peek()]) ret.push(i);
            else if (hights[i] < hights[ret.peek()]) {
                ret.clear();
                ret.push(i);
            }
        }
        return ret;
    }
    
}