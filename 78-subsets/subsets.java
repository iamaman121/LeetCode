class Solution {
    private void generateAllSubsets(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        generateAllSubsets(idx+1, nums, curr, ans);
        curr.remove(curr.size()-1);
        generateAllSubsets(idx+1, nums, curr, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAllSubsets(0, nums, curr, ans);
        return ans;
    }
}