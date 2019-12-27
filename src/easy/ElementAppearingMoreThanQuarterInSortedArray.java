package easy;

/**
 * ClassName: ElementAppearingMoreThanQuarterInSortedArray.java
 * Author: chenyiAlone
 * Create Time: 2019/12/27 20:01
 * Description: No.1287 Element Appearing More Than Quarter In Sorted Array
 */
public class ElementAppearingMoreThanQuarterInSortedArray {

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        for (int i = 0, cnt = 0, pre = arr[0]; i < len; i++) {
            if (arr[i] == pre) {
                cnt++;
                if (cnt > len / 4.0) return arr[i];
            } else {
                pre = arr[i];
                cnt = 1;
            }

        }
        return -1;
    }
    
}

