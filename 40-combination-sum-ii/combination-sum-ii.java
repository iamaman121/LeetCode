class Solution {
    private void generateCombinations(int[] arr, int i, List<Integer> curr, List<List<Integer>> ans, int target){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        else if(target<0 || i==arr.length) return;
        else if(i+1<arr.length && arr[i]==arr[i+1]){
            generateCombinations(arr, i+1, curr, ans, target);
        }
        else{
            int cnt=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]==arr[j]) ++cnt;
                else break;
            }
            for(int j=0;j<cnt;j++){
                curr.add(arr[i]);
                generateCombinations(arr, i+1, curr, ans, target-(j+1)*arr[i]);
            }
            for(int j=0;j<cnt;j++){
                curr.remove(curr.size()-1);
            }
            generateCombinations(arr, i+1, curr, ans, target);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        Arrays.sort(arr);
        generateCombinations(arr, 0, curr, ans, target);
        return ans;
    }
}