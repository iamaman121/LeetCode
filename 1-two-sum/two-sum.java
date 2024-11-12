class Solution {
    public int[] twoSum(int[] nums, int tar) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(tar-nums[i])){
                int[] ans= {hm.get(tar-nums[i]),i};
                return ans;
            }
            hm.put(nums[i],i);
        }
        int[] ans = new int[2];
        return ans;
    }
}