package medium;

/**
 * Given n non-negative integers a1, a2, ..., an , where each 
 * represents a point at coordinate (i, ai). n vertical lines 
 * are drawn such that the two endpoints of line i is at (i, ai) 
 * and (i, 0). Find two lines, which together with x-axis forms 
 * a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author chenyiAlone
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0;
        int lo = 0;
        int hi = height.length -1;
        while (hi > lo) {
        	int area = (hi - lo) * Math.min(height[hi], height[lo]);
    		if (ans < area) {
    			ans =area; 
    		}
    		if (height[hi] < height[lo])  hi--;
    		else lo++;
        }
    	return ans;
    }

    public int maxAreaOld(int[] height) {	// O(n^2) 
    	int ans = 0;
    	for (int i = 0; i < height.length; i++) {
    		for (int j = i + 1; j < height.length; j++) {
    			int area = (j - i) * Math.min(height[i], height[j]);
    			if (ans < area) {
    				ans =area; 
    			}
    		}
    	}
    	return ans;
    }

	public static void main(String[] args) {
		ContainerWithMostWater md = new ContainerWithMostWater();
		int[] nums = {1,8,6,2,5,4,8,3,7};
		System.out.println(md.maxArea(nums));
	}
}
