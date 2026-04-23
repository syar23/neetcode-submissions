class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target, curr,0);
        return result;
    }

    private void dfs(int[ ] nums, int target, List<Integer> curr, int i) {
        if(target==0) {
            result.add(new ArrayList(curr));
            return;
        }
        if(target <0 || i>=nums.length)
            return;
        curr.add(nums[i]);
        dfs(nums,target-nums[i],curr,i+1);
        curr.remove(curr.size()-1);
        while ((i + 1 < nums.length) && nums[i] == nums[i + 1]) 
            i++;
        dfs(nums,target,curr,i+1);
    }
}
