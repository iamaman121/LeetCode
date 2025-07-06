class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> store = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int value = target - nums[i];
            if(store.containsKey(value)){
                int[] ans = {store.get(value),i};
                return ans;
            }
            else{
                store.put(nums[i],i);
            }
        }
        return null;
    }
}