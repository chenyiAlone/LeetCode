package easy;
import static util.Utils.*;
/**
 * 
 * ClassName: SearchInsertPosition
 * @author chenyiAlone  
 * Create Time: 2018/12/05 11:49:32
 * Description: 遍历有序数组，返回插入位置,有序数组可以使用二分查找
 */
public class SearchInsertPosition {
    /**
     * 二分查找法查找插入点
     * @param nums 有序数组
     * @param target 被查找元素
     * @return 插入点下标
     */
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) hi = mid;
            else if (nums[mid] < target) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    
    /**
     * 普通迭代查找
     * @param nums 有序数组
     * @param target 被查找元素
     * @return 插入点下标
     */
    public int searchInsert_low(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
    
    public static void main(String[] args) {
        int[] nums = initArray(5);
        printArray(nums);
        System.out.println(new SearchInsertPosition().searchInsert(nums, 1));
    }
}
