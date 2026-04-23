class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length<1)
            return digits;
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i]<9) {
                digits[i]++;
                return digits;
            } else {
                digits[i]=0;
            }
        }
           // If we are here, all digits were 9
            int[] result = new int[digits.length + 1];
            result[0] = 1; // e.g. [9,9,9] -> [1,0,0,0]
            return result;
            
        
    }

}
