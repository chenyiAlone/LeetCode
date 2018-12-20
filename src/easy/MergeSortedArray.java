package easy;
/**
 * 
 * ClassName: MergeSortedArray
 * @author chenyiAlone  
 * Create Time: 2018/12/20 21:24:29
 * Description: No.88
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:
    
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    Example:
    
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    
    Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1, k = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if ( j < 0) nums1[i] = nums2[k--];
            else if ( k < 0) nums1[i] = nums1[j--];
            else if (nums1[j] > nums2[k]) nums1[i] = nums1[j--];
            else nums1[i] = nums2[k--];
                
        }
    }
}
