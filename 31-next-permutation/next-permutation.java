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
            int nextBigNumIdx= idx+1;
            for(int j=idx+2;j<n;j++){
                if(nums[j]>nums[idx] && nums[j]<=nums[nextBigNumIdx]) nextBigNumIdx= j;
            }
            swap(nums, idx, nextBigNumIdx);
            reverse(nums, idx+1, n-1);
        }
    }
}