class Solution {
    private Set<Integer> set = new HashSet<>();
    private List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0, subset);
        return res;
    }

    //i is index in nums
    public void dfs(int[] nums, int i, List<Integer> subset) {
        if(i>=nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums,i+1,subset);
        subset.remove(subset.size()-1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums,i+1,subset);
            
    }
}
