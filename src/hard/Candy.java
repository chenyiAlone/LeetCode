package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * ClassName: Candy
 * @author chenyiAlone  
 * Create Time: 2019/04/24 18:23:02
 * Description: No.135
 * 思路:
 * time: O(lg N), space: O(n)
 *    1. java 中没有 pair 这种容器，所以用了 Map.Entry<K, V>，自定义了比较器比较 V 的值
 *    2. 将 <ratings[i], i> 放进 list 中排序
 *    3. ratings[i] 从低到高取出对应的下标进行计算
 *    4. r = 1，没人至少有一个糖，如果 ratings[i] 大于它两边的值，就更新为那个位置的 candies + 1
 * 
 * 
 */
public class Candy {
    public int candy(int[] ratings) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            map.put(i, ratings[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.print("[" +entry.getKey() +",　" + entry.getValue() + "], ");
        }
        System.out.println();
        int total = 0;
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            int r = 1;
            int cur_value = list.get(i).getValue();
            int cur_index = list.get(i).getKey();
            System.out.println(cur_index + " + " + cur_value);
            if (cur_index - 1 >= 0 && cur_value > ratings[cur_index - 1]) {
                r = Math.max(r, candies[cur_index - 1] + 1);
            }            
            if (cur_index + 1 < ratings.length && cur_value > ratings[cur_index + 1]) {
                r = Math.max(r, candies[cur_index + 1] + 1);
            }
            candies[cur_index] = r;
            System.out.println("candies[" + cur_index + "]= " + candies[cur_index]);
        }
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}
