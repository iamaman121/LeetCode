class Solution {
    private boolean checkBit(int n, int i){
        return (n&(1<<i))>0;
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n= nums.length, totalNum= 1<<n;
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<totalNum;i++){
            List<Integer> temp= new ArrayList<>();
            for(int j=0;j<n;j++){
                if(checkBit(i, j)){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}