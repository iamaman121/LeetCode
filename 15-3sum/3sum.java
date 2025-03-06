class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> store = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int tar= -nums[i];
            int left = i+1, right = n-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum<tar){
                    ++left;
                }
                else if(sum>tar){
                    --right;
                }
                else{
                    store.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                }
            }
        }
        return new ArrayList<>(store);
    }
}
