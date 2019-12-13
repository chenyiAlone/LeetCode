package easy;

/**
 * ClassName: LongPressedName.java
 * Author: chenyiAlone
 * Create Time: 2019/12/13 21:32
 * Description: No.925 Long Pressed Name
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        for (int i = 0, j = 0; i < name.length(); ) {
            if (j == typed.length()) return false;
            if (name.charAt(i) == typed.charAt(j)) {
                i++;    j++;
            } else {
                while (j > 0 && j < typed.length() && typed.charAt(j) == typed.charAt(j - 1))
                    j++;
                if (j == typed.length() || name.charAt(i) != typed.charAt(j)) return false;
                
            }
        }
        return true;
    }
    
}