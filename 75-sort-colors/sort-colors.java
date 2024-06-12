class Solution {
    public void swap(int[] arr, int i, int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
    public void sortColors(int[] nums) {
        int p0= 0, p2= nums.length-1;
        for(int i=0;i<=p2;){
            if(nums[i]==0){
                swap(nums, p0, i);
                ++p0; ++i;
                // swap(nums[p0++],nums[i++]);
            }
            else if(nums[i]==2){
                swap(nums, p2, i);
                p2--;
                // swap(nums[p2--],nums[i]);
            }
            else ++i;
        }
    }
}