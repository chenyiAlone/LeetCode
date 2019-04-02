package hard;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: TextJustification
 * @author chenyiAlone  
 * Create Time: 2019/04/02 18:21:11
 * Description: No.68
 * 思路:
 *   真的要被这道题目搞死了，开始用自己的思路来做一遍的， 所有的地方都没有问题，唯独是均匀分配空格的地方出了问题了，
 *   自己的代码的输出和结果十分相近，自己的为"example  of text"，答案为 "example of  text"，最后研究了一下讨论区的示例
 *   1. 通过贪心来计算一行最多有几个单词一次他们的长度
 *   2. count 记录 line n * words length + n - 1 个空格的长度
 *   3. 分两种情况
 *      i.最后一排 last == words.length，或者最后一排只有一个单词 dif == 0 (即 index + 1 == last)
 *          1）str 追加 words[i] + " "
 *          2) delete char at str.length() - 1
 *     ii.其他排
 *          1) 计算剩余的空格数 spaces = (maxWidth - count) / dif
 *          2) 计算 r = (maxWidth - count) % dif
 *          3) 除去最后一个 words,其余的 words 后面都要追加空格补齐
 *          4）将取余剩下的空格 r ,在前 index + r 空格区间中，每个多加一个
 *          
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
    
    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
    
    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
    
    For the last line of text, it should be left justified and no extra space is inserted between words.
    
    Note:
    
    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.
    Example 1:
    
    Input:
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Example 2:
    
    Input:
    words = ["What","must","be","acknowledgment","shall","be"]
    maxWidth = 16
    Output:
    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be",
                 because the last line must be left-justified instead of fully-justified.
                 Note that the second line is also left-justified becase it contains only one word.
    Example 3:
    
    Input:
    words = ["Science","is","what","we","understand","well","enough","to","explain",
             "to","a","computer.","Art","is","everything","else","we","do"]
    maxWidth = 20
    Output:
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]         
 *          
 */ 
public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(new TextJustification().fullJustify(words, maxWidth).get(1).toString());
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        if (words == null || words.length < 1) 
            return res;
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth)
                    break;
                count += 1 + words[last].length();
                last++;
            }
            int dif = last - index - 1;
            StringBuilder str = new StringBuilder();
            if (last == words.length || dif == 0) {
                // last line
                for (int i = index; i < last; i++) {
                    str.append(words[i] + " ");
                }
                str.deleteCharAt(str.length() - 1);
                while (str.length() < maxWidth) {
                    str.append(" ");
                }
            } else {
                // 
                int spaces = (maxWidth - count) / dif;
                int r = (maxWidth - count) % dif;
                for (int i = index; i < last; i++) {
                    str.append(words[i]);
                    if (i < last - 1) {
                        /* line0 = { example  of text };
                         * index = 0;
                         * last = 2;
                         * dif = 2 - 0 - 1 = 1;
                         * count = 15;
                         * space = (16 - 15) / 2 = 0;
                         * r = 1 % 2 = 1;
                         */
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            str.append(" ");
                        }
                    }
                }
            }
            res.add(str.toString());
            index = last;
        }
        return res;
    }
}