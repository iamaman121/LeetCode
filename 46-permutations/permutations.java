class Solution {
    private void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    private void permuteUtil(List<Integer> nums, int idx, List<List<Integer>> ans){
        if(idx==nums.size()-1){
            ans.add(new ArrayList<>(nums));
            return;
        }
        permuteUtil(nums, idx+1, ans);
        for(int j=idx+1;j<nums.size();j++){
            swap(nums, idx, j);
            permuteUtil(nums, idx+1, ans);
            swap(nums, idx, j);
        }
    }
    public List<List<Integer>> permute(int[] arr) {
        List<Integer> nums= new ArrayList<>();
        for(int a: arr) nums.add(a);
        List<List<Integer>> ans = new ArrayList<>();
        permuteUtil(nums, 0, ans);
        return ans;
    }
}