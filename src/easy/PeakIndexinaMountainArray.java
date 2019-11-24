package easy;

/**
 * ClassName: PeakIndexinaMountainArray.java
 * Author: chenyiAlone
 * Create Time: 2019/11/24 19:32 
 * Description: No.852 Peak Index in a Mountain Array
 */
public class PeakIndexinaMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if ((mid == 0 && A[mid] > A[mid + 1])
                || (mid == A.length - 1 && A[mid] < A[mid + 1])
                || (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]))
                return mid;
            else if (mid < A.length - 1 && A[mid] < A[mid + 1])
                l = mid + 1;
            else if (mid > 0 && A[mid - 1] > A[mid])
                r = mid - 1;
        }
        return l;
    }
    
}