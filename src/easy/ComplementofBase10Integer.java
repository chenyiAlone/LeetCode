package easy;

/**
 * ClassName: ComplementofBase10Integer.java
 * Author: chenyiAlone
 * Create Time: 2019/1/8 21:11 
 * Description: No.1009 Complement of Base 10 Integer
 */
public class ComplementofBase10Integer {

    public int bitwiseComplement(int N) {
        if (N < 2) return N == 1 ? 0 : 1;
        return (N % 2 == 1 ? 0 : 1) + bitwiseComplement(N / 2) * 2;
    }

}