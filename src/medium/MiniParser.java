package medium;

import util.NestedInteger;
/**
 * ClassName: MiniParser.java
 * Author: chenyiAlone
 * Create Time: 2019/7/26 22:53
 * Description: No.385 Mini Parser
 * 思路:
 *
 *      1. dfs 配合全局的  index，因为基本类型不能传 指针
 *      2. 嵌套会开启新的 dfs() new NestedInteger() 用来搜索嵌套中的内容，
 *          而继续搜索继续使用当前的 NestedInteger 搜索下一个元素
 *
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 *
 * Given s = "324",
 *
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 *
 * Given s = "[123,[456,[789]]]",
 *
 * Return a NestedInteger object containing a nested list with 2 elements:
 *
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 */
public class MiniParser {
    
    private char[] str;
    private int index = 0;

    private void dfs(NestedInteger ni) {
        if (str[index] == ']') {
            index++;
            return;
        }
        if (str[index] == '[') {
            index++;
            NestedInteger next = new NestedInteger();
            ni.add(next);
            dfs(next);
        } else {
            int sign = 1, num = 0;
            if (str[index] == '-') {
                sign = -1;
                index++;
            }
            for ( ; index < str.length && '0' <= str[index] && str[index] <= '9'; index++) {
                num = num * 10 + str[index] - '0';
            }
            ni.add(new NestedInteger(num * sign));
        }
        if (str[index] == ',') {
            index++;
            dfs(ni);
        } else {
            dfs(ni);
        }
    }


    public NestedInteger deserialize(String s) {
        NestedInteger ret = new NestedInteger();
        str = s.toCharArray();
        if (str[index] == '[') {
            index++;
            dfs(ret);
        } else {
            return new NestedInteger(Integer.valueOf(s));
        }
        return ret;
    }
    
}