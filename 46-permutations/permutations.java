class Solution {
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void permuteUtil(int[] nums, int idx, List<List<Integer>> ans){
        if(idx==nums.length-1){
            List<Integer> res= new ArrayList<>();
            for(int num: nums) res.add(num);
            ans.add(res);
            return;
        }
        for(int j=idx;j<nums.length;j++){
            swap(nums, idx, j);
            permuteUtil(nums, idx+1, ans);
            swap(nums, idx, j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteUtil(nums, 0, ans);
        return ans;
    }
}