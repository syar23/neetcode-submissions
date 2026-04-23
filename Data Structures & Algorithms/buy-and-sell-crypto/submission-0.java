class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p; // slide "buy" to a cheaper day
            else maxProfit = Math.max(maxProfit, p - minPrice); // try selling today
        }
        return maxProfit;
    }
}
