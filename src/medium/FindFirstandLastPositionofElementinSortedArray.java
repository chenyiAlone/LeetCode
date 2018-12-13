package medium;
/**
 * 
 * ClassName: FindFirstandLastPositionofElementinSortedArray
 * @author chenyiAlone  
 * Create Time: 2018/12/13 19:58:49
 * Description: No.34 二分查找元素的长度
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int start = -1, end = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1; 
            else hi = mid - 1;
        }
        start = lo;
        
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) lo = mid + 1; 
            else hi = mid - 1 ;
        }
        end = hi;
        if (end - start >= 0){
            ans[0] = start;
            ans[1] = end;
        }
        return ans;
    }
}
