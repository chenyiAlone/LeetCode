package medium;
/**
 * ClassName: RangeSumQueryMutable.java
 * Author: chenyiAlone
 * Create Time: 2019/5/22 12:47
 * Description: No.307
 * 思路:
 *      1. 树状数组，从 1 开始计数，不能使用 0 当做下标志
 *      2. add(int id, int n) 将 nums[i] 的值 n 加到所有父节点的 sum[id] 上，id 的变化是通过
 *
 *
 *
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutable {
    private int[] sum;
    private int len;

    private void add(int id, int n) {
        for (; id <= len; id += (id & (-id))) {
            sum[id] += n;
        }
    }

    private int getSum(int id) {
        int res = 0;
        for (int i = id + 1; i > 0; i -= i & -i) {
            res += sum[i];
        }
        return res;
    }


    public RangeSumQueryMutable(int[] nums) {
        len = nums.length;
        sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            add(i + 1, nums[i]);
        }

    }

    public void update(int i, int val) {
        add(i + 1, -(getSum(i) - getSum(i - 1)));
        add(i + 1, val);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */