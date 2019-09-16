package medium;

/**
 * ClassName: ImplementsRand10UsingRand7.java
 * Author: chenyiAlone
 * Create Time: 2019/9/14 21:30
 * Description: No.470 Implements Rand10() Using Rand7()
 *
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
 *
 * Do NOT use system's Math.random().
 *
 *  
 *
 * Example 1:
 *
 * Input: 1
 * Output: [7]
 * Example 2:
 *
 * Input: 2
 * Output: [8,4]
 * Example 3:
 *
 * Input: 3
 * Output: [8,1,10]
 *  
 *
 * Note:
 *
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is called.
 *  
 *
 * Follow up:
 *
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 *
 */

public class ImplementsRand10UsingRand7 {
    private int rand7() {
        return 7;
    }
    public int rand10() {
        long sum = 0;
        for (int i = 0; i < 10; i++) sum += rand7();
        return (int)(1 + sum % 10);
    }

}