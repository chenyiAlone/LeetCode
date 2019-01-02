package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: PascalsTriangleII
 * @author chenyiAlone  
 * Create Time: 2019/01/02 08:32:01
 * Description: No.119
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

    Note that the row index starts from 0.
    
    
    In Pascal's triangle, each number is the sum of the two numbers directly above it.
    
    Example:
    
    Input: 3
    Output: [1,3,3,1]
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> array = new ArrayList<>();
            array.add(1);
            if (i > 2) {
                List<Integer> preList = ans.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    array.add(j, preList.get(j) + preList.get(j - 1));
                }
            }
            if (array.size() < i) array.add(1);
            ans.add(array);
        }
        return ans.get(rowIndex);
    }
    public static void main(String[] args) {
        int rowIndex = 5;
        System.out.println(new PascalsTriangleII().getRow(rowIndex));
    }
}
