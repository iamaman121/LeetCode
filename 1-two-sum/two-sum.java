class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(hm.containsKey(complement)){
                ans[0]= hm.get(complement);
                ans[1]= i;
                break;
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return ans;
    }
}