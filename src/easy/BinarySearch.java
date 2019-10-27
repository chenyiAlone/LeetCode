package easy;

/**
 * ClassName: BinarySearch.java
 * Author: chenyiAlone
 * Create Time: 2019/10/27 23:27
 * Description: No.704 Binary Search
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target)
                l = mid + 1;
            else if (target < nums[mid])
                r = mid - 1;
            else return mid;
        }
        return -1;
    }
}