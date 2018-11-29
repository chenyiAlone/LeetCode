package easy;

/**
 * Roma to number
 * @author chenyiAlone
 *
 */
public class RomaToNumber {
    public static int romaToNumber(String s) {
        int result = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                temp = 1;
                if (i < s.length() - 1) {
                    if      (s.charAt(i+1) == 'V') { temp = 4;  i++; }
                    else if (s.charAt(i+1) == 'X') { temp = 9;  i++; }
                }
            } else if (c == 'X') {
                temp = 10;
                if (i < s.length() - 1) {
                    if      (s.charAt(i+1) == 'L') { temp = 40;  i++; }
                    else if (s.charAt(i+1) == 'C') { temp = 90;  i++; }
                }
            } else if (c == 'C') {
                temp = 100;
                if (i < s.length() - 1) {
                    if      (s.charAt(i+1) == 'D') { temp = 400;  i++; }
                    else if (s.charAt(i+1) == 'M') { temp = 900;  i++; }
                }
            } else if (c == 'V') { temp = 5; }
              else if (c == 'L') { temp = 50;}
              else if (c == 'D') { temp = 500;}
              else if (c == 'M') { temp = 1000;}
            result += temp;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(romaToNumber("XIX"));
    }
}
