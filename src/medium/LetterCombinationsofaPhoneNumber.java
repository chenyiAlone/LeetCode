package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * ClassName: LetterCombinationsofaPhoneNumber
 * @author chenyiAlone  
 * Create Time: 2018/12/08 14:46:28
 * Description: No.17 使用队列的出队/入队操作完成字符串的拼接
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        LinkedList<String> list = new LinkedList<String>(); 
        for (int i = 0; i < len; i++) {
            apped(list, digits.charAt(i) - '2');
        }
        return list;
    }
    
    public static List<String> apped(LinkedList<String> list, int n) {
        String[][] strs = { {"a", "b", "c"},
                            {"d", "e", "f"},
                            {"g", "h", "i"},
                            {"j", "k", "l"},
                            {"m", "n", "o"},
                            {"p", "q", "r", "s"},
                            {"t", "u", "v"},
                            {"w", "x", "y", "z"}
                          };
        int len = list.size();
        if (len == 0) {
            list.addAll((List<String>)Arrays.asList(strs[n]));
        } else {
            for (int i = 0; i < len; i++) {
                String s = list.poll();
                for (int j = 0; j < strs[n].length; j++)
                    list.offer(s + strs[n][j]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations(digits));
    }
}

