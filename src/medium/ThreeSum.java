package medium;
/**
 * @author chenyiAlone
 * @date 2018.11.30
 */
import java.util.*;

public class ThreeSum
 {

	public List<List<Integer>> threeSum(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int seek = -(nums[i] + nums[j]);
				lo = j + 1;
				hi = nums.length - 1;
				int mid = 0;
				boolean flag = false;
				while (lo <= hi) {
					mid = (lo + hi) / 2;
					if 		(nums[mid] < seek) lo = mid + 1;
					else if (seek < nums[mid]) hi = mid - 1;
					else { flag = true; break; }
				}
				if (flag) {
					List<Integer> list = new ArrayList<>();
					list.add(new Integer(nums[mid]));
					list.add(new Integer(nums[i]));
					list.add(new Integer(nums[j]));
					for (List temp : ans){
						if (temp.containsAll(list)) {
							flag = false;
							break;
						}
					}
					if (flag) ans.add(list);
				}
			}
		}
		return ans;
	}
	
}
