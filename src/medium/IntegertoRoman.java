package medium;
/**
 *
 * @author chenyiAlone
 *
 */
public class IntegertoRoman {
	public String intToRoman(int num) {
		String[][] c = {
			{"","I","II","III","IV","V","VI","VII","VIII","IX"},
			{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
			{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
			{"","M","MM","MMM"}
			};
		StringBuilder roma = new StringBuilder();
		int i;
		boolean flag = true;
		for (i = 3; i >= 0; i--) {
			int id = ((int)(num/Math.pow(10, i)))%10;
			if (flag) {
				roma.append(c[i][id]);
				flag = false;
			}else {
				roma.append(c[i][id]);
			} 
		}
		return roma.toString();
	}
	public static void main(String[] args) {
		IntegertoRoman ir = new IntegertoRoman();
		System.out.println(ir.intToRoman(19));
	}
}
