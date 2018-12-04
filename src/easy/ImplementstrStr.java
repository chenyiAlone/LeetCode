package easy;
/**
 * 
 * ClassName: ImplementstrStr
 * @author chenyiAlone  
 * Create Time: 2018/12/04 17:30:29
 * Description: 匹配字符串，最好的方法应该是使用KMP算法
 */
public class ImplementstrStr {
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
}
