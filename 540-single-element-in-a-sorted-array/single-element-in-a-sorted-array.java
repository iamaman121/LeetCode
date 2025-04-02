class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            // Ensure mid is even (since pairs start at even indices)
            if (mid % 2 == 1) {
                mid--;
            }
            
            // If the pair is still valid, move right
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                // Otherwise, move left
                hi = mid;
            }
        }
        
        return nums[lo]; // Lo will point to the single element
    }
}
