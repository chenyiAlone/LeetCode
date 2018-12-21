package hard;

import static util.Utils.printArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * ClassName: SubstringwithConcatenationofAllWords
 * @author chenyiAlone  
 * Create Time: 2018/12/21 12:42:55
 * Description: No.30
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
    
    Example 1:
    
    Input:
      s = "barfoothefoobarman",
      words = ["foo","bar"]
    Output: [0,9]
    Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
    The output order does not matter, returning [9,0] is fine too.
    Example 2:
    
    Input:
      s = "wordgoodgoodgoodbestword",
      words = ["word","good","best","word"]
    Output: []
 *=======================================
 *  采用的是暴力搜索，结果直接超时
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        permutaion(words, set, 0);
        System.out.println("set.size() = " + set.size());
        System.out.println(set);
//        String str = "aaaaaa";
//        kmpSearch(s, str, ans);
        for (String str : set) {
            System.out.println(s + " + " +  str);
//            kmpSearch(s, str, ans);
            violenSearch(s, str, ans);
        }
        return ans;
    }
    public static void violenSearch(String str, String pattern, List<Integer> list) {
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            boolean isPat = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    isPat = false;
                    break;
                }
            }
            if (isPat) list.add(i); 
        }
    }
    
    public static void permutaion(String[] words, Set<String> set, int p) {
        if (p == words.length) {
            StringBuilder sb = new StringBuilder();
            for (String s : words) {
                sb.append(s);
//                System.out.print(s + " ");
            }
            set.add(sb.toString());
        }
        for (int i = p; i < words.length; i++) {
            String temp = words[p];
            words[p] = words[i];
            words[i] = temp;
            
            permutaion(words, set, p + 1);
            
            temp = words[p];
            words[p] = words[i];
            words[i] = temp;
        }
    }
    
    public static int[] kmpArray(String needle) {
        int[] nums = new int[needle.length() + 1];
        nums[0] = -1;
        nums[1] = 0;
        int len = 0;
        int i = 1, n = needle.length();
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
    
    public static void kmpSearch(String haystack, String needle, List<Integer> list) {
        int kmp[] = kmpArray(needle);
        printArray(kmp);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == m - 1) {
                    System.out.println(i - j);
                    list.add(i -j);
                    System.out.println(haystack + " + " + needle + "\n");
                    j = kmp[j];
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
    }
    
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(new SubstringwithConcatenationofAllWords().findSubstring(s, words));
    }
}
