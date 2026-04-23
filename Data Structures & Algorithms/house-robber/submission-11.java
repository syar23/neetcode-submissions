class Solution {
private int[] memo;
    public int rob(int[] nums) {
        //intuition
        //dp[i] = max money that can be robbed at ith house
        //dp[i]  = max(dp[i-2] + nums[i],dp[i-1])
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n<1) return 0;
        if(n==1)
            return nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

}
