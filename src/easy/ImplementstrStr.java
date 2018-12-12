package easy;

import static util.Utils.*;
/**
 * 
 * ClassName: ImplementstrStr
 * @author chenyiAlone  
 * Create Time: 2018/12/04 17:30:29
 * Description: No.28 匹配字符串，最好的方法应该是使用KMP算法
 */
public class ImplementstrStr {
    /**
     * 暴力搜索
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        boolean flag;
        if (haystack.equals("") && needle.equals("")) return 0; 
        for (int i = 0; i < haystack.length(); i++) {
           flag = true;
           if (needle.length() + i > haystack.length()) return -1;
           for (int j = 0; j < needle.length(); j++) {
               if (haystack.charAt(i + j) != needle.charAt(j))  {
                   flag = false;
                   break;
               }
           }
           if (flag) {
               return i;
           }
       } 
        return -1; 
    }
    
    /**
     * kmp算法的查找
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrByKmp(String haystack, String needle) {
        return kmpSearch(haystack, needle);
    }
    public static int[] kmpArray(String needle) {
        int[] nums = new int[needle.length() + 1];
        nums[0] = -1;
        nums[1] = 0;
        int len = 0;
        int i = 2, n = needle.length();
        while (i < n) {
            if (needle.charAt(len) == needle.charAt(i)) {
                len++;
                nums[i + 1] = len;
                i++;
            } else {
                if (len > 0) {
                    len = nums[len];
                } else {
                    nums[i + 1] = len;
                    i++;
                }
            }
        }
        return nums;
    }
    public static int kmpSearch(String haystack, String needle) {
        int kmp[] = kmpArray(needle);
        printArray(kmp);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == m - 1) {
                    System.out.println(i - j);
                     return i - j;
//                    j = kmp[j];
                }
                j++;
                i++;
            } else {
                j = kmp[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String haystack = "ababcd";
        String needle = "abc";
//        System.out.println(new ImplementstrStr().strStr(haystack, needle));
//        printArray(kmpArray(needle));
        kmpSearch(haystack, needle);
    }
}
