class Solution {
    public String longestPalindrome(String s) {
        //intuition
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int resIndex = 0;
        int resLength = 0;
        for(int i=n-1;i>=0;i--) {
            for( int j=i;j<=n-1;j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==true)){
                    dp[i][j]=true;
                    if(j-i+1 >resLength) {
                        resIndex = i;
                        resLength = j-i+1;
                    }        
                }
            }
        }
        return s.substring(resIndex,resIndex+resLength);
    }
}
