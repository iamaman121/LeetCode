class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap= new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
            if(i<k) continue;
            heap.remove();
        }
        return heap.peek();
    }
}