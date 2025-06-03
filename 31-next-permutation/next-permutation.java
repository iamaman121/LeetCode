class Solution {
    private void swap(int[] nums, int idx1, int idx2){
        int temp= nums[idx1];
        nums[idx1]= nums[idx2];
        nums[idx2]= temp;
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start++, end--);
        }
    }
    public void nextPermutation(int[] nums) {
        int n= nums.length, idx= -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx= i;
                break;
            }
        }
        if(idx==-1) reverse(nums, 0, n-1);
        else{
            int justLargerIdx= idx+1;
            for(int j=n-1;j>idx+1;j--){
                if(nums[j]>nums[idx] && nums[j]<=nums[justLargerIdx]){
                    justLargerIdx= j; break;
                }
            }
            swap(nums, idx, justLargerIdx);
            reverse(nums, idx+1, n-1);
        }
    }
}