class Solution {
    public int firstMissingPositive(int[] nums) {
        int n= nums.length, i=0;
        while(i<n){
            if(nums[i]<1 || nums[i]>n || nums[i]-1==i){
                i++;
            }
            else{
                int idx= nums[i]-1;
                if(nums[idx]==nums[i]){
                    i++;
                    continue;
                }
                int temp= nums[idx];
                nums[idx]= nums[i];
                nums[i]= temp;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]-1!=i) return i+1;
        }
        return n+1;
    }
}