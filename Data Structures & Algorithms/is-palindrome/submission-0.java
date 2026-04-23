class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        

        while (i < j) {
            // move i to next alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            // move j to previous alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            char left  = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));
            if (left != right) return false;

            i++; j--;
        }
        return true;
    }
}
