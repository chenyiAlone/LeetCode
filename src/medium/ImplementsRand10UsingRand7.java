package medium;

/**
 * ClassName: ImplementsRand10UsingRand7.java
 * Author: chenyiAlone
 * Create Time: 2019/9/ 
 * Description: No.470 Implements Rand10() Using Rand7()
 */

public class ImplementsRand10UsingRand7 {
    public int rand7() { 
        return 7;
    }
    public int rand10() {
        long sum = 0;
        for (int i = 0; i < 10; i++) sum += rand7();
        return (int)(1 + sum % 10);
    }

}