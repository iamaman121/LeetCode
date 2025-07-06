class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> store = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int value = target - nums[i];
            if(store.containsKey(value)){
                ans[0]= store.get(value);
                ans[1]= i;
                break;
            }
            else{
                store.put(nums[i],i);
            }
        }
        return ans;
    }
}