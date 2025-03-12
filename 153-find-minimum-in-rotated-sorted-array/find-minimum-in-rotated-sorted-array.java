class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        //check edge case
        if(n<=1 || nums[0]<nums[n-1]) return nums[0];

        int low= 0, high= n-1, mid, ans=n-1;
        while(low<=high){
            mid= low+(high-low)/2;
            if(nums[mid]<nums[0]){
                ans= mid;
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return nums[ans];
    }
}