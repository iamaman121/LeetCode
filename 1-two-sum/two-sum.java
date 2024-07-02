class Solution {
    public int[] twoSum(int[] nums, int tar) {
        HashMap<Integer,Integer> ump= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(ump.containsKey(tar-nums[i])){
                return new int[]{i, ump.get(tar-nums[i])};
            }
            else{
                ump.put(nums[i],i);
            }
        }
        return null;
    }
}