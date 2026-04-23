class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> table1 = new HashMap<>();
        Map<Character, Integer> table2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            table1.put(a, table1.getOrDefault(a, 0) + 1);
            table2.put(b, table2.getOrDefault(b, 0) + 1);
        }
        return table1.equals(table2);
    }
}
