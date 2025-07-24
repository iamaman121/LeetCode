// https://leetcode.com/problems/sort-colors/description/
class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n= nums.length;
        int p0= 0, p2= n-1, curr= 0;
        while(curr<=p2){
            if(nums[curr]==0){
                swap(nums, p0++, curr++);
                
            }
            else if(nums[curr]==1){
                curr++;
            }
            else{
                swap(nums, p2, curr);
                p2--;
            }
        }
    }
}