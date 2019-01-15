package medium;
import static util.Utils.*;

import java.util.Arrays;
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) return -1;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int apartSum = nums[i] + nums[j];
                System.out.println("apartSum = " + apartSum);
                int seed = target - apartSum;
                System.out.println("seed = "  + seed);
                int index = searchClosest(nums, j + 1, nums.length - 1, seed);
                int sum = apartSum + nums[index];
                ans = (Math.abs(target - sum) < Math.abs(target - ans)) ? sum : ans;
            }
        }
        return ans;
    }
    public static int searchClosest(int[] nums, int lo, int hi, int target) {
        int oldHi = hi, oldLo = lo;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(lo + " + " + hi);
            if (target < nums[mid]) hi = mid -1;
            else if (nums[mid] < target) lo = mid + 1;
            else {
                hi = mid;
                break;
            }
        }
        if (hi < oldLo) hi = oldLo;
        System.out.println("oldHi = " + oldHi);
        if (hi < oldHi) {
            hi = Math.abs(target - nums[hi]) < Math.abs(target - nums[hi + 1]) ? hi : hi + 1;
        }
        return hi;
    }
    
    public static void main(String[] args) {
        int[] nums = initArray(-1,2,1,-4);
                
        int target = 1;
        Arrays.sort(nums);
        printArray(nums);
        
        
//        System.out.println(searchClosest(nums, 0, nums.length - 1, target));
//        System.out.println(Arrays.binarySearch(nums, -target));
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
