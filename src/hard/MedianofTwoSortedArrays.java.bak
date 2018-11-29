package hard;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 *      nums1 = [1, 3]
 *      nums2 = [2]
 *      
 *      The median is 2.0
 * 
 * Example 2:
 *      nums1 = [1, 2]
 *      nums2 = [3, 4]
 *      
 *      The median is (2 + 3)/2 = 2.5
 *      
 * @author chenyiAlone
 *
 */
class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
    	int mid = (len1 + len2) / 2;   // 使用了一个(len1 + len1) / 2大小的数组来作为临时数组，用于查找中位数
    	int[] array = new int[mid + 1];
    	for (int i  = 0, j = 0, k = 0; i < array.length; i++) {    // 归并排序
    		if   	(j == len1) { array[i] = nums2[k++]; }
    		else if (k == len2) { array[i] = nums1[j++]; }
    		else if (nums1[j] > nums2[k]) { array[i] = nums2[k++]; }
    		else { array[i] = nums1[j++]; }
    	}
//    	for (int i : array) {
//    	    System.out.print(i + " ");
//    	}
//    	System.out.println();
//    	System.out.println("mid = " + mid + "  (len1 + len2) % 2 = " + (len1+len2) % 2);
    	if ((len1+len2) % 2 == 0) {
    		return (array[mid] + array[mid - 1]) / 2.0; 
    	}
    	return array[mid];
    }
    public static void main(String[] args) {
        MedianofTwoSortedArrays s = new MedianofTwoSortedArrays();
        int[] nums1 = {1, 4};
        int[] nums2 = {2, 3};
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}