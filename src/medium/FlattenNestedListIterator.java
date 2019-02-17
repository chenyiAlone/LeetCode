package medium;

import java.util.LinkedList;
import java.util.List;
import util.NestedInteger;
/**
 * 
 * ClassName: FlattenNestedListIterator
 * @author chenyiAlone  
 * Create Time: 2019/02/17 21:35:28
 * Description: No.341
 * Given a nested list of integers, implement an iterator to flatten it.
    
    Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    
    Example 1:
    
    Input: [[1,1],2,[1,1]]
    Output: [1,1,2,1,1]
    Explanation: By calling next repeatedly until hasNext returns false, 
                 the order of elements returned by next should be: [1,1,2,1,1].
    Example 2:
    
    Input: [1,[4,[6]]]
    Output: [1,4,6]
    Explanation: By calling next repeatedly until hasNext returns false, 
                 the order of elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator {
    
    LinkedList<Integer> res = new LinkedList<>();
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        helper(res, nestedList);
       
    }

    public Integer next() {
        return res.pop();
    }

    public boolean hasNext() {
        return !res.isEmpty();
    }
    
    public static void helper(List<Integer> res, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res.add(nestedInteger.getInteger());
            } else {
                helper(res, nestedInteger.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

