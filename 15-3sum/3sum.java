class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length, target, left, right;
        Arrays.sort(nums);
        HashSet<String> cache = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            target = -nums[i]; left= i+1; right= n-1;
            while(left<right){
                int twoSum = nums[left]+nums[right];
                if(twoSum>target){
                    --right;
                }
                else if(twoSum<target){
                    ++left;
                }
                else{
                    int[] sum = {nums[i], nums[left], nums[right]};
                    if(cache.contains(Arrays.toString(sum))==false){
                        cache.add(Arrays.toString(sum));
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    ++left; --right;
                }
            }
        }
        return ans;
    }
}