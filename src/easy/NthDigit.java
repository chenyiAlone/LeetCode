package easy;

public class NthDigit {
    public int findNthDigit(int n) {
        int seek = 1, t = 1;
        while (seek + (int)Math.pow(10, t) * (t + 1) < n) {
            seek += (int)Math.pow(10, t) * t++;
        }
        int poin = (int)(n - Math.pow(10, t - 1));
        int base = (int)Math.pow(10, t - 1);
        int add = (poin / t);
        int num = base + add;
        int res = (n - base) % t;
//        System.out.println("res" + res);
        res = n == 10 ? 1 : t - res - 1;
//        System.out.println(t - res - 1);
//        System.out.println("num" + num);
//        System.out.println("res" + res);
//        System.out.println();
        while (res-- > 0) {
            num /= 10;
        }
//        System.out.println("poin" + poin);
//        System.out.println("base" + base);
//        System.out.println("add" + add);
//        System.out.println(t + " " + seek);
//        System.out.println();
        
        return num % 10;
    }
    public static void main(String[] args) {
        NthDigit nd = new NthDigit();
        int n = 16;
        for (int i = 1; i < 1001; i++) {
//            nd.findNthDigit(i);
            
            System.out.print(nd.findNthDigit(i));
            
        }
    }
}