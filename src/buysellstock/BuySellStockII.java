package buysellstock;

public class BuySellStockII {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) 
            maxprofit += Math.max(0, prices[i] - prices[i - 1]);
        return maxprofit;
    }
}
