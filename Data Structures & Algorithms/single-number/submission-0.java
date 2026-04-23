class Solution {
    public int singleNumber(int[] nums) {
        //Property 1: a ^ a = 0
        //Property 2: a ^ 0 = a
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR
        }
        return result;
    }
}
