package easy;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i = 1; i < pattern.length(); i++) {
            boolean flag = true;
            for (int j = i - 1; j >= 0; j--) {
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    if (!strs[i].equals(strs[j])) {
                        flag = false;
                    } 
                } else {
                    if (strs[i].equals(strs[j])) {
                        flag = false;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "fish whoops helloworld fish";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}
