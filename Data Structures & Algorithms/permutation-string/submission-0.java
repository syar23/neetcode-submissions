class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] freqArr1 = new int[26];
        int[] freqArr2 = new int[26];

        for(int i=0;i<s1.length();i++) {
            freqArr1[s1.charAt(i)-'a']++;
            freqArr2[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for(int i=0;i<26;i++) {
            if(freqArr1[i]==freqArr2[i])
                matches++;
        }

        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            if(matches == 26)
                return true;
            int index = s2.charAt(r) - 'a';
            freqArr2[index]++;
            if (freqArr1[index]==freqArr2[index])
                matches++;
            else if (freqArr1[index]+1 == freqArr2[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            freqArr2[index]--;
            if (freqArr1[index] == freqArr2[index]) {
                matches++;
            } else if (freqArr1[index] - 1 == freqArr2[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
