package medium;
/**
 * 
 * ClassName: MultiplyStrings
 * @author chenyiAlone  
 * Create Time: 2018/12/26 20:33:20
 * Description: No.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuffer ans = new StringBuffer("0");
        for (int i = 0; i < num2.length(); i++) {
//            char c = 10;
            String sumApart = num1;
            StringBuffer temp = new StringBuffer();
            multiplySingle(sumApart, num2.charAt(i), temp, sumApart.length() - 1, 0);
            for (int j = 0; j < i; j++) {
                temp.append("0");
            }
            System.out.println("sumApart = " + sumApart + "  temp = " + temp);
            addSB(temp, ans);
//            ans.append("0");
            
        }
//        ans.setLength(ans.length() - 1);
        return ans.toString();
    }
    public static void addSB(StringBuffer temp, StringBuffer ans) {
        String sumApartStr = temp.toString();
        String ansStr = ans.toString();
//        int i = Math.max(temp.length(), ans.length());
        int cy = 0;
        ans.setLength(0);
        System.out.println("方法中的 sum = " + sumApartStr + "  ansStr = " + ansStr);
        for (int i = sumApartStr.length() - 1, j = ansStr.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int num1 = 0, num2 = 0;
            if (i >= 0) num1 = sumApartStr.charAt(i) - '0';
            if (j >= 0) num2 = ansStr.charAt(j) - '0';
            int sum = num1 + num2 + cy;
            cy = sum / 10;
            ans.append("" + sum % 10);
        }
        if (cy != 0) ans.append("" + cy);
        ans.reverse();
        System.out.println("方法中" + ans);
    }
    
    public static void multiplySingle(String num, char numSingle, StringBuffer sb, int n, int cy) {
        if (numSingle == '0' || num.charAt(0) == '0') {
            sb = new StringBuffer("0");
            return;
        }
        if (n == 0) {
            sb.append("" + ((num.charAt(n) - '0') * (numSingle - '0') + cy));
            return;
        }
        int sum = (num.charAt(n) - '0') * (numSingle - '0') + cy;
        System.out.println("sum = " + sum);
        int bit = sum % 10;
        cy = sum /10;
        multiplySingle(num, numSingle, sb, n -1, cy);
        sb.append(bit);
    }
    public static void main(String[] args) {
        String num1 = "333";
        String num2 = "44";
        StringBuffer sb1 = new StringBuffer(num1);
        StringBuffer sb2 = new StringBuffer(num2);
        addSB(sb1, sb2);
//        System.out.println(sb2);
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
    
}
