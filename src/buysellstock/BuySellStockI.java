package buysellstock;

public class BuySellStockI {
    public int maxProfit(int[] p) {
        // buy at least value and sell at highest value
        if (p == null || p.length <= 1) {
            return 0;
        }
        
        int buy = p[0];
        int max = 0;      
         for(int i=1; i<p.length; i++) {
            max = Math.max(max,p[i]-buy);
            buy = Math.min(buy, p[i]);
        }
        return max;    
    }
}
