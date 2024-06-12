class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n= nums.length, idx= -1;
        for(int i=n-2;i>=0;--i){
            if(nums[i]<nums[i+1]){
                idx= i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums, 0);
            return;
        }
        for(int i=n-1;i>idx;--i){
            if(nums[i]>nums[idx]){
                swap(nums, i, idx);
                reverse(nums, idx+1);
                break;
            }
        }
    }
}