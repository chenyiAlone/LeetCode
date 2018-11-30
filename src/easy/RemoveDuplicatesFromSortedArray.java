package easy;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int i, j;
		for (i = 1, j = 0; i < nums.length; i++) {
			if (nums[i] == nums[j]) {
				nums[i] = 0;
			} else {
				nums[++j] = nums[i];
			}
		}
		if (i != j + 1) nums[i-1]= 0;
		return j + 1;
	}
}
