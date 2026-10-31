class Solution {
    public int lengthOfLongestSubstring(String s) {
   /* int[] last = new int[128];  // ASCII; use a HashMap for full Unicode
    Arrays.fill(last, -1);

        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last[c] >= start) {          // repeated inside window
                start = last[c] + 1;
            }
            last[c] = i;
            max = Math.max(max, i - start + 1);
        }
        return max;*/

        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
