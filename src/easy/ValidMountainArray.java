package easy;

/**
 * ClassName: ValidMountainArray.java
 * Author: chenyiAlone
 * Create Time: 2019/1/5 20:38 
 * Description: No.941 Valid Mountain Array
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        int index = 0;
        while (index < len - 1 && A[index] < A[index + 1]) {
            index++;
        }
        if (index == 0 || index == len - 1) return false;
        while (index < len - 1 && A[index] > A[index + 1]) {
            index++;
        }
        return index == len - 1;
    }

}