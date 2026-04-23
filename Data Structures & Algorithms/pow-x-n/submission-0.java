class Solution {
    public double myPow(double x, int n) {

        double result = 1.0;
        if(n==0)
            return result;
        for(int i=1;i<=Math.abs(n);i++) {
                 result = result*x;
        }

        if(n<0) {
            return 1/result;
        }
     
        return result;
    }
}
