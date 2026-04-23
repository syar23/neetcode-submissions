class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int pals = 0;
        for(int i=n-1;i>=0;i--) {
            for(int j=i;j<=n-1;j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==true )) {
                    pals++;
                    dp[i][j]=true;
                }
            }
        }
        return pals;
        
    }
}
