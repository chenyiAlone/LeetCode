package medium;

/**
 * @author chenyiAlone
 * @date 2020/10/12 20:25
 *
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 思路：
 *
 * 终止条件使用短路来实现，在 n > 0 的过程中都会调用 sumNum 方法，将值累加到全局变量中
 *
 *
 *
 */
public class Offer64 {

    private int ret = 0;

    public int sumNums(int n) {
        boolean x = n > 0 && sumNums(n - 1) > 0;
        ret += n;
        return ret;
    }

}