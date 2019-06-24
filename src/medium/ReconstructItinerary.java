package medium;

import java.util.*;
/**
 * ClassName: ReconstructItinerary.java
 * Author: chenyiAlone
 * Create Time: 2019/6/24 14:19
 * Description: No.332
 *
 *
 * 思路:
 *      1. map<String, List<Integer>> 用来记录位置，和以这位置为起点的边
 *      2. trace[size] 用来记录那条边没有被走过
 *      3. 将 <from, to> 按照 to 的字典序进行排序，这样最先 dfs 到的肯定是字典序最小的一条路
 *
 *
 *
 *
 *
 * 332. Reconstruct Itinerary
 * Medium
 *
 * 753
 *
 * 497
 *
 * Favorite
 *
 * Share
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 *
 */
public class ReconstructItinerary {
    private Map<String, List<Integer>> map = new HashMap<>();
    private List<List<String>> T;
    private boolean[] trace;
    private int size, cnt;
    private List<String> res = new ArrayList<>();

    private void dfs(String from, List<String> temp) {
        if (res.size() > 0) return;
        temp.add(from);
        if (cnt > size) return;
        if (cnt == size) {
            res.addAll(temp);
            return;
        }
        for (int next : map.get(from)) {
            if (!trace[next]) {
                trace[next] = true;
                cnt++;
                dfs(T.get(next).get(1), temp);
                cnt--;
                trace[next] = false;
            }
        }
        temp.remove(temp.size() - 1);
    }


    public List<String> findItinerary(List<List<String>> tickets) {
        size = tickets.size();
        trace = new boolean[size];
        T = tickets;
        for (int i = 0; i < size; i++) {
            String a = T.get(i).get(0), b = T.get(i).get(1);
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());  // 需要将所有点都 push 进去
            map.get(a).add(i);
        }
        for (String key: map.keySet()) {
            List<Integer> list = map.get(key);
            list.sort(new Comparator<>() {  // 按照终点的字典序进行排序
                @Override
                public int compare(Integer a, Integer b) {
                    return T.get(a).get(1).compareTo(T.get(b).get(1));
                }
            });
        }
        dfs("JFK", new ArrayList<>());
        return res;

    }

}
