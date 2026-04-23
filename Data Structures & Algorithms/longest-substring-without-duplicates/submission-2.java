class Solution {
    public int lengthOfLongestSubstring(String s) {
    int[] last = new int[128];  // ASCII; use a HashMap for full Unicode
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
        return max;
    }
}
