class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> freq= new HashMap<>();
        freq.put(0,1); int ans= 0, csum= 0;
        for(int i=0;i<nums.length;i++){
            csum+= nums[i];
            ans+= freq.getOrDefault(csum-k, 0);
            freq.put(csum, freq.getOrDefault(csum, 0)+1);
        }
        return ans;
    }
}