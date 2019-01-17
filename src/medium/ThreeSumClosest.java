package medium;

import static util.Utils.*;
import java.util.Arrays;

/**
 * 
 * ClassName: ThreeSumClosest
 * @author chenyiAlone  
 * Create Time: 2019/01/17 19:51:20
 * Description: No.16
 * 总结：
 * 1. res初始化为 0, 1, nums.length 三项下标数组元素之和
 * 2. 使用双指针 lo, hi扫描
 * 3. 比较 res 和 sum 跟target的差的绝对值 
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
       int res = nums[0] + nums[1] + nums[nums.length - 1];
       Arrays.sort(nums);
       for (int i = 0; i < nums.length - 2; i++) {
           int lo = i + 1, hi = nums.length - 1;
           while (lo < hi) {
               int sum = nums[i] + nums[lo] + nums[hi];
               if (sum < target) {
                   lo++;
               } else {
                   hi--;
               }
               if (Math.abs(target - sum) < Math.abs(target - res)) {
                   
               }
           }
       }
       return res;
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
