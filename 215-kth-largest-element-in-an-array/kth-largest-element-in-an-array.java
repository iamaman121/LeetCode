class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length;
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        for(int i=k;i<n;i++){
            if(nums[i]>minHeap.peek()){
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}