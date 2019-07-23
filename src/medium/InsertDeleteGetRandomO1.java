package medium;

import java.util.*;
/**
 * ClassName: InsertDeleteGetRandomO1.java
 * Author: chenyiAlone
 * Create Time: 2019/7/22 0:01
 * Description: No.380 Insert Delete GetRandom O(1)
 * 思路:
 *
 *      1. map + list
 *      2. map 保存 <val, index>
 *      3. 添加 map.put(val, list.size());  arr.add(va;);
 *         删除
 *              arr.set(map.get(val), arr.get(arr.size() - 1)); // 将被删除所在位置的值更新为最后一位的值
 *              map.put(arr.get(arr.size() - 1), map.get(val));
 *              map.remove(val);
 *              arr.remove(arr.size() - 1);
 *
 *
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 */
public class InsertDeleteGetRandomO1 {
    List<Integer> arr;
    Map<Integer, Integer> map;
    Random random;
    
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        map.put(arr.get(arr.size() - 1), map.get(val));
        arr.set(map.get(val), arr.get(arr.size() - 1));
        map.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get((random.nextInt(arr.size())));
    }
}
