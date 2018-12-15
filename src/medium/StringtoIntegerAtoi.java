package medium;
/**
 * 
 * ClassName: StringtoIntegerAtoi
 * @author chenyiAlone  
 * Create Time: 2018/12/15 15:01:32
 * Description: No.8
 */
public class StringtoIntegerAtoi {
    // +-  越界 
    public int myAtoi(String str) {
        if (str.length() == 0 || str == null) return 0;
        int sgin = 1;
        int firstNum = 0;
        str = str.trim();
        char c = str.charAt(0);
        if (c == '-') {
            sgin = -1;
        } else {
            
        }
        
        return 0;
    }
}
