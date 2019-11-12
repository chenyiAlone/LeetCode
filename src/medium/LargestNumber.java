package medium;

import java.util.*;
/**
 * ClassName: LargestNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/11/12 14:45
 * Description: No.179 Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumber {
    
    public String largestNumber(int[] nums) {
        String[] words = new String[nums.length];
        boolean zero = true;
        for (int i = 0; i < nums.length; i++) {
            words[i] = Integer.toString(nums[i]);
            if (nums[i] != 0) zero = false;
        }
        if (zero) return "0";
        Arrays.sort(words, (a, b)-> {
                StringBuilder sba = new StringBuilder(a), sbb = new StringBuilder(b);
                sba.append(b);
                sbb.append(a);
                for (int i = 0; i < sba.length(); i++) {
                    if (sba.charAt(i) < sbb.charAt(i)) return 1;
                    else if (sba.charAt(i) > sbb.charAt(i)) return -1;
                }
                return 0;
        });
        StringBuilder ret = new StringBuilder();
        for (String s : words) {
            ret.append(s);
        }
        return ret.toString();
    }
    
}
