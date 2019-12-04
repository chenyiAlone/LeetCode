package medium;

import java.util.*;

/**
 * ClassName: BrickWall.java
 * Author: chenyiAlone
 * Create Time: 2019/12/4 15:12 
 * Description: No.554 Brick Wall
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = wall.size();
        for (List<Integer> list : wall) {
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i);
                if (i != list.size() - 1) {
                    if (map.containsKey(total)) 
                        map.put(total, map.get(total) + 1);
                    else 
                        map.put(total, 1);
                    ret = Math.min(ret, wall.size() - map.get(total));
                }

            }
        }
        return ret;
    }
    
}