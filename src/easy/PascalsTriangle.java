package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ClassName: PascalsTriangle
 * @author chenyiAlone  
 * Create Time: 2018/12/29 15:45:32
 * Description: No.118
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


    In Pascal's triangle, each number is the sum of the two numbers directly above it.
    
    Example:
    
    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> array = new ArrayList<>();
            array.add(1);
            if (i > 2) {
                List<Integer> preList = ans.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    System.out.println("j = " + j + preList);
                    array.add(j, preList.get(j) + preList.get(j - 1));
                }
            }
            if (array.size() < i) array.add(1);
            System.out.println("array = " + array);
            ans.add(array);
            System.out.println(ans.size());
        }
        return ans;
    }
    public static void main(String[] args) {
        int numRows = 1;
//        List l = new ArrayList(3);
//        System.out.println(l.size());
//        System.out.println(l);
        System.out.println(new PascalsTriangle().generate(numRows));
    }

}
