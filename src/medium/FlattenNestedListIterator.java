package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.NestedInteger;
/**
 * 
 * ClassName: FlattenNestedListIterator
 * @author chenyiAlone  
 * Create Time: 2019/02/17 21:35:28
 * Description: No.341
 *
 * 思路:
 * 一、
 *      1. 使用栈来完成，栈用于记录当前层的下一个位置，用于从下一层的退出
 *      2. toNext()
 *          1). 先进行判断是否需要向外跳
 *          2). 跳完以后还到达了末尾，证明已经到了最外层，直接退出
 *          3). 当前的为 List 就进入 List
 *          4). 如果新进入的 List 为空，就再往外跳
 *
 * 二、
 *      直接遍历保存到 List 中
 *
 *
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
public class FlattenNestedListIterator implements Iterator<Integer> {
    private int curP;
    private List<NestedInteger> curList;
    private Stack<Pair> stack = new Stack<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        curList = nestedList;
        curP = 0;
        toNext();
    }

    private void outList() {
        while (curP >= curList.size()) {
            if (stack.isEmpty()) break;

            Pair pair = stack.pop();
            curP = pair.p;
            curList = pair.list;    // 向外层跳
        }
    }

    private void toNext() {
        outList();
        if (curP >= curList.size()) return;
        NestedInteger n = curList.get(curP);
        while (n != null && !n.isInteger()) {
            stack.push(new Pair(curP + 1, curList));
            curP = 0;
            curList = n.getList();
            if (curList.size() == 0) outList();
            n = curList.size() > curP ? curList.get(curP) : null;
        }
    }


    @Override
    public Integer next() {
        int ret = curList.get(curP++).getInteger();
        toNext();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return curP < curList.size();
    }

    private class Pair {
        private int p;
        private List<NestedInteger> list;

        private Pair(int p, List<NestedInteger> list) {
            this.p = p;
            this.list = list;
        }
    }



    /*
    *  1.使用 List 来直接保存所有的结果
    *
    */
    private class Old {
        LinkedList<Integer> res = new LinkedList<>();
        public Old(List<NestedInteger> nestedList) {
            helper(res, nestedList);

        }

        public Integer next() {
            return res.pop();
        }

        public boolean hasNext() {
            return !res.isEmpty();
        }

        private void helper(List<Integer> res, List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    res.add(nestedInteger.getInteger());
                } else {
                    helper(res, nestedInteger.getList());
                }
            }
        }

    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

