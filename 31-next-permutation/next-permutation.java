class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start++, end--);
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int pivot = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot= i;
                break;
            }
        }
        if(pivot!=-1){
            for(int i=n-1;i>pivot;i--){
                if(nums[i]>nums[pivot]){
                    swap(nums, i, pivot);
                    break;
                }
            }
        }
        reverse(nums, pivot+1, n-1);
    }
}