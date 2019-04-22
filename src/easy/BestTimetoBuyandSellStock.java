package easy;
/**
 * 
 * ClassName: BestTimetoBuyandSellStock
 * @author chenyiAlone  
 * Create Time: 2019/04/22 16:07:43
 * Description: No.121
 * 思路:
 *     逆向遍历数组，将最大值 max 保存下来，profit 取 max 和当前值的差更大的那个
 *     
 * Say you have an array for which the ith element is the price of a given stock on day i.
    
    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    
    Note that you cannot sell a stock before you buy one.
    
    Example 1:
    
    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                 Not 7-1 = 6, as selling price needs to be larger than buying price.
    Example 2:
    
    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.     
 * 
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length < 1)
            return profit;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max)
                max = prices[i];
            profit = Math.max(profit, max - prices[i]);
        }
        return profit;
    }
}