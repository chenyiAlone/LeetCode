package medium;

/**
 * ClassName: NextGreaterElementIII.java
 * Author: chenyiAlone
 * Create Time: 2019/12/2 14:28 
 * Description: No.556 Next Greater Element III
 */
public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        StringBuilder num = new StringBuilder(Integer.toString(n));
        int fs = -1, fl = -1;
        for (int i = num.length() - 2; i >= 0; i--) {
            if (num.charAt(i) < num.charAt(i + 1)) {
                fs = i;
                break;
            }
        }
        if (fs == -1) return -1;
        for (int i = num.length() - 1; i > fs; i--) {
            if (num.charAt(i) > num.charAt(fs)) {
                fl = i;
                break;
            }
        }
        char c = num.charAt(fs);
        num.setCharAt(fs, num.charAt(fl));
        num.setCharAt(fl, c);
        int l = fs + 1, r = num.length()- 1;
        while (l < r) {
            char t = num.charAt(l);
            num.setCharAt(l++, num.charAt(r));
            num.setCharAt(r--, t);
        }
        long ret = Long.parseLong(num.toString());
        return  ret > Integer.MAX_VALUE && ret > n ? -1 : (int)ret;
    }
    
}