package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i +1; j < prices.length; j++) {
                int sell = prices[j];
                if (buy > sell)
                    continue;
                res = Math.max(res, sell - buy);
            }
        }
        return res;
    }
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
    public int maxProfit3(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {// 寻找最低波谷
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {// 寻找最低波谷后的最高波峰吗，计算出二者的差值便是利润
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }
    public int maxProfit4(int[] prices) {
        // 每个数，记住左边最小的值
        if( prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for( int price : prices){
            if (min > price){
                min = price;
            }
            if( price - min > maxProfit){
                maxProfit =  price - min;
            }
        }
        return maxProfit;
    }

}
