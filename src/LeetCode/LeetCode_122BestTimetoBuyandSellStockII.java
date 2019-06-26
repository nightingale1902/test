package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_122BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length == 0){
            return 0;
        }
        int getProfit = 0;
        int maxProfit = 0;
        for (int i = 0; i <= prices.length - 2; i++) {
            getProfit = prices[i + 1] - prices[i]; //i + 1 最大为prices.length - 1
            if (getProfit > 0)
                maxProfit += getProfit;
        }
        return maxProfit;
    }
}
