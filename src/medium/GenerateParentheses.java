package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: GenerateParenthese
 * @author chenyiAlone  
 * Create Time: 2019/01/18 21:45:03
 * Description: No.22
 * 总结：
 *     1. if (left > right)=> 用来检测左右平衡
 *     2. 先左后右，左右数量相等，加入res
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:
    
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParentheses().generateParenthesis(n));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }
    public static void helper(List<String> res, String s, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
            
        }
    }
}
