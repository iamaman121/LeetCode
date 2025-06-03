class Solution {
    private void swap(int[] nums, int index1, int index2){
        int temp= nums[index1];
        nums[index1]= nums[index2];
        nums[index2]= temp;
    }
    public void sortColors(int[] nums) {
        int ptr0= 0, ptr= 0, ptr2= nums.length-1;
        while(ptr<=ptr2){
            if(nums[ptr]==0){
                swap(nums, ptr0++, ptr);
                if(ptr<ptr0) ptr= ptr0;
            }
            else if(nums[ptr]==2){
                swap(nums, ptr, ptr2--);
            }
            else ptr++;
            
        }
    }
}