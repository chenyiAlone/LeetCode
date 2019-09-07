package easy;

/**
 * ClassName: .java
 * Author: chenyiAlone
 * Create Time: 2019/9/7 
 * Description: No.485 Max Consecutive Ones
 */
public MaxConsecutiveOnes {

    
    public int findMaxConsecutiveOnes(int[] nums) {
            int ptr = 0, cnt = 0, ret = 0;
            for (int i : nums) {
                if (i == 1) {
                    cnt += 1;
                    ret = Math.max(ret, cnt);
                } else {
                    cnt = 0;
                }
            }
            return ret;
        }
    }
}