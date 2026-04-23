class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];
        dfs(nums,curr, picked);
        return result;
    }

    //l is length of permutation it should become from length of array to 0
    public void dfs(int[] nums, List<Integer> curr, boolean[] picked) {
        if(curr.size()==nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!picked[i]) {
                curr.add(nums[i]);
                picked[i]=true;
                dfs(nums,curr,picked);
                curr.remove(curr.size()-1);
                picked[i]=false;
            }
        }
    }
}
