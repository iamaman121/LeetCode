class Solution {
    private int findMinIndex(int[] nums){
        int low= 0, high= nums.length-1;
        while(low<high){
            int mid= low+(high-low)/2;
            if(nums[mid]<nums[high]){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private int binarySearch(int[] nums, int lo, int hi, int target){
        int mid;
        while(lo<=hi){
            mid= lo+(hi-lo)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) hi= mid-1;
            else lo= mid+1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n= nums.length;
        int ind= findMinIndex(nums);
        System.out.println(ind);
        if(nums[n-1]<target){
            return binarySearch(nums, 0, ind-1, target);
        }
        else{
            return binarySearch(nums, ind, n-1, target);
        }
    }
}