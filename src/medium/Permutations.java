package medium;

import static util.Utils.exch;
import static util.Utils.printArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * ClassName: Permutations
 * @author chenyiAlone  
 * Create Time: 2018/12/14 09:13:31
 * Description: No.46 全排列
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Integer[] ansInt = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ansInt[i] = Integer.valueOf(nums[i]);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        permute(ansInt, 0, ans);
        return ans;
        
    }
    public static void permute(Integer[] nums, int p, List<List<Integer>> list) {
        
        if (p == nums.length - 1) {
            List<Integer> ans = new ArrayList(Arrays.asList(nums));
            System.out.println(ans);
            list.add(ans);
        }
        
        for (int i = p; i < nums.length; i++) {
            Integer temp = nums[p];
            nums[p] = nums[i];
            nums[i] = temp;
            
            permute(nums, p + 1, list);
            
            temp = nums[p];
            nums[p] = nums[i];
            nums[i] = temp;
        }
    }
/*    public List<List<Integer>> permute(int[] nums) {
    return null;    
    }
    public static void perm(int[] nums) {
        perm(nums, 0, nums.length);
    }
    
    public static void perm(int[] nums, int p, int q) {
        if (p == q - 1)
            printArray(nums);
        else {
            for (int i = p; i < q; i++) {
                exch(nums, p, i);
                perm(nums, p + 1, q);
                exch(nums, p, i);
            }
        }
    }*/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
//        new Permutations().permute(nums);
        System.out.println(new Permutations().permute(nums));
//        Arrays.asList(nums).add
//        List list = new ArrayList(Arrays.asList(nums));
//        Integer.
//        System.out.println();
    }
}
