package easy;

/**
 * ClassName: FindNumberswithEvenNumberofDigits.java
 * Author: chenyiAlone
 * Create Time: 2019/12/28 20:59 
 * Description: No.1295 Find Number swith EvenNumber of Digits
 */
public class FindNumberswithEvenNumberofDigits {

    public int findNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            int bs = 0;
            while (n > 0) {
                n /=10;
                bs++;
            }
            if (bs % 2 == 0) ret++;
        }   
        return ret; 
    }
    
}