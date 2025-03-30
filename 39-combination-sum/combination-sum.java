class Solution {
    private void generateCombinations(int[] arr, int i, List<Integer> curr, List<List<Integer>> ans, int target){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        else if(target<0 || i==arr.length) return;
        curr.add(arr[i]);
        generateCombinations(arr, i, curr, ans, target-arr[i]);
        curr.remove(curr.size()-1);
        generateCombinations(arr, i+1, curr, ans, target);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        generateCombinations(arr, 0, curr, ans, target);
        return ans;
    }
}