package easy;
/**
 * ClassName: MinimumMovestoEqualArrayElements.java
 * Author: chenyiAlone
 * Create Time: 2019/9/4 22:25
 * Description: No.453 Minimum Moves to Equal Array Elements
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */
public class MinimumMovestoEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) min = Math.min(min, i);
        int ret = 0;
        for (int i : nums) ret += i - min;
        return ret;
    }

}
