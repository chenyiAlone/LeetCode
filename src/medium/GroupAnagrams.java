package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * ClassName: GroupAnagrams
 * @author chenyiAlone  
 * Create Time: 2019/03/27 16:35:08
 * Description: No.49
 * 思路：
 *   1. 遍历数组元素，将每个 str 进行排序
 *   2. HashMap<String, Integer> 来储存排序后的 str
 *   3. List<List<String>> 的下标和 HashMap<String, Integer> 中保存的 Integer 一一对应
 *   4. 使用 hashcode 来完成相同对象的归类
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String tmp = String.valueOf(arr);
            if (map.containsKey(tmp)) {
                res.get(map.get(tmp)).add(strs[i]);
            } else {
                map.put(tmp, count++);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
            }
        }
        return res;
    }
}
