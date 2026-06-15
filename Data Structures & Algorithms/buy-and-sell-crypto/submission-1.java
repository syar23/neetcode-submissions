class Solution {
    public int maxProfit(int[] prices) {
        /*int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int p : prices) {
            if (p < minPrice) 
                minPrice = p; // slide "buy" to a cheaper day
            else 
                maxProfit = Math.max(maxProfit, p - minPrice); // try selling today
        }
        return maxProfit;*/

        //brute force
        int maxProfit = 0;
        for(int i=0;i<prices.length-1;i++) {
            for(int j=i+1; j<prices.length;j++) {
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }
}
