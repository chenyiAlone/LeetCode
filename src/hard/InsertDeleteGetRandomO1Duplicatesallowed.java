package hard;

import java.util.*;
/**
 * ClassName: InsertDeleteGetRandomO1Duplicatesallowed.java
 * Author: chenyiAlone
 * Create Time: 2019/7/24 22:10
 * Description: No.381 Insert Delete GetRandom O(1) - Duplicates allowed
 * 思路:
 *
 *      本来已经做出来了其实，但是因为没去掉 debug 的 System.out.println() 而导致超时了
 *      1. ArrayList<Integer> 用来保存插入的所有的元素
 *      2. Map<Integer, Set<Integer>> 用来保存每个元素的所有的在 list 中的下标
 *      3. insert:
 *              1) list.add(val)
 *              2) map.get(val).add(list.size())
 *         delete:
 *              1) int rm = map.get(val).iterator().next() // 通过 iterator 获取到 set 中的一个要删除的位置
 *              2) list.set(rm, list.get(list.size() - 1)), list.remove(list.size() - 1) // 将该位置的值设
 *                  // 置成最后一个元素的值，并将最后一个元素删除
 *              3) Set<Integer> rmSet = map.get(val); // 要删除的元素的所有位置
 *                 Set<Integer> chSet = map.get(list.get(list.size() - 1)); // 最后一个元素的所有位置
 *                      [1] rmSet == chSet // 直接删除 rmSet.remove(list.size())
 *                      [2] rmSet != chSet // chSet 中的 list.size() - 1 这个位置更换为 rm
 *                                         // rmSet 中删除 rm
 *
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 *
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 *
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 *
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 *
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 *
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 *
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 *
 */
public class InsertDeleteGetRandomO1Duplicatesallowed {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1Duplicatesallowed() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if (!map.containsKey(val)) {
            flag = true;
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {

        if (!map.containsKey(val)) return false;
        int last = list.size() - 1, lastVal = list.get(last);
        Set<Integer> rmSet = map.get(val);
        Set<Integer> chSet = map.get(lastVal);

        int rm = rmSet.iterator().next();

        if (chSet == rmSet) {
            rmSet.remove(last);
        } else {
            chSet.remove(last);
            chSet.add(rm);

            rmSet.remove(rm);

        }

        list.set(rm, lastVal);
        list.remove(last);
        if (rmSet.isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */