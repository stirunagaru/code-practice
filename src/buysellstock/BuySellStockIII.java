package buysellstock;

public class BuySellStockIII {
//	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solution/
	public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        
        int t1C = Integer.MAX_VALUE;
        int t2C = t1C;
        
        int t1P = 0;
        int t2P = 0;
        
        for(int price : prices) {
            t1C = Math.min(t1C, price);
            t1P = Math.max(t1P, price - t1C);
            
            t2C = Math.min(t2C, price - t1P);
            t2P = Math.max(t2P, price - t2C);
        }
        
        
        return t2P;
        
        
        
        
//         int leftMin = prices[0];
//         int rightMax = prices[len-1];
        
        
//         int[] leftP = new int[len];
//         int[] rightP = new int[len + 1];
        
//         for (int l = 1; l < len; ++l) {
//             leftP[l] = Math.max(leftP[l-1], prices[l] - leftMin);
//             leftMin = Math.min(leftMin, prices[l]);
            
//             int r = len-1-l;
//             rightP[r] = Math.max(rightP[r+1], rightMax-prices[r]);
//             rightMax = Math.max(rightMax, prices[r]);
//         }
        
//         int maxProfit = 0;
//         for (int i = 0; i < len; i++) {
//             maxProfit = Math.max(maxProfit, leftP[i] + rightP[i+1]);
//         }
//         return maxProfit;
    }
}
