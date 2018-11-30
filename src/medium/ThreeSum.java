package medium;
import java.util.*;
/**
 * 
 * ClassName: ThreeSum
 * @author chenyiAlone  
 * Create Time: 2018/11/30 12:26:28
 * Description: 程序还有问题需要调试....
 */
public class ThreeSum
 {

	public List<List<Integer>> threeSum(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int seek = -(nums[i] + nums[j]);
				lo = j + 1;
				hi = nums.length - 1;
				int mid = 0;
				boolean flag = false, hasRep = false;
				while (lo <= hi) {
					mid = (lo + hi) / 2;
					if 		(nums[mid] < seek) lo = mid + 1;
					else if (seek < nums[mid]) hi = mid - 1;
					else { flag = true; break; }
				}
				if (flag) {
				    
				    
					List<Integer> list = new ArrayList<>();
					list.add(Integer.valueOf(nums[i]));
					list.add(Integer.valueOf(nums[j]));
					list.add(Integer.valueOf(nums[mid]));
					for (List temp : ans){
					    for (int k = 0; k < 3; k++) {
					        if (temp.get(k) != list.get(k)) {
					            flag = false;
					        }
					    }
					    if (flag == true) { // 有重复
					        hasRep = true; 
					        break;
					    } else {
					        flag = true;
					    }
					}
					if (!hasRep) ans.add(list);
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(new ThreeSum().threeSum(nums));
    }
	
}
