package easy;

public class PalindromeNumber {
    public static boolean isPlaindromeNumberByFor(int x) {
        String s = Integer.toString(x);
        int mid = s.length() / 2;
        for (int i = 0, j = s.length() - 1; i < mid; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int x = 1001;
        System.out.println(isPlaindromeNumberByFor(x));
    }
}
