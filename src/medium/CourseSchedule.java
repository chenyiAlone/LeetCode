package medium;

import java.util.*;
/**
 * ClassName: CourseSchedule.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/7 17:07
 * Description: No.207
 * 思路:
 *      1. Topological sorting 拓扑排序，实现有有向无环图的线性排序，BFS 入度为
 *      2. 可能存在很多结点，缺只有一条边的情况，那么使用邻接矩阵会造成空间的浪费，
 *              reorder 顶点重新编号
 *              edges   顶点即有向边
 *              degree  入度
 *              queue   BFS
 *      3. que 中存放入度为 0 的顶点，枚举 que 中的顶点的所有的相邻顶点，并将它们的 degree 入度 - 1，
 *          为 0 的时候就加入到 que，当所有顶点的 degree 入度都为 0 ，证明存在
 *
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> reorder = new HashMap<>();
        List<List<Integer>> edges = new ArrayList<>();
        int[] degree = new int[numCourses];

        int index = 0;
        for (int[] prere : prerequisites) {
            int src = prere[1], target = prere[0];
            if (!reorder.containsKey(target)) {
                reorder.put(target, index++);
                edges.add(new ArrayList<>());
            }
            if (!reorder.containsKey(src)) {
                reorder.put(src, index++);
                edges.add(new ArrayList<>());
            }
            int src_index = reorder.get(src), target_index = reorder.get(target);
            edges.get(src_index).add(target_index);
            degree[target_index] += 1;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < edges.size(); i++) {    // list 只保存用于有向边的结点，题目要求为存在，使用 edges.size() 即可
            if (degree[i] == 0)
                que.offer(i);
        }
        while (!que.isEmpty()) {
            int v = que.poll();
            for (Integer i : edges.get(v)) {
                degree[i] -= 1;
                if (degree[i] == 0)
                    que.offer(i);
            }
        }
        for (Integer i : degree)
            if (i != 0)
                return false;
        return true;
    }
}
