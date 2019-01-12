package easy;
/**
 * 
 * ClassName: TwoSumIlInputarrayissorted
 * @author chenyiAlone  
 * Create Time: 2019/01/12 21:27:58
 * Description: No.167
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    
    Note:
    
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.
    Example:
    
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (i >  0 && numbers[i] == numbers[i - 1]) continue;
            int seed = target - numbers[i];
            int lo = i + 1, hi = numbers.length - 1;
    //        System.out.println("lo = " + lo + "  hi = " + hi);
            while (lo <= hi) {
                int mid = (hi - lo) / 2 + lo;
                System.out.println("lo = " + lo + "  hi = " + hi);
                if      (numbers[mid] < seed) lo = mid + 1;
                else if (seed < numbers[mid]) hi = mid - 1;
                else return new int[]{i + 1, mid + 1};
            }
        }
        return null;
    }
}
