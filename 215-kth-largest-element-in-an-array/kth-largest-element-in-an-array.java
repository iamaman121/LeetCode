class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthLargestElement(nums, nums.length, k);
    }
    private int kthLargestElement(int[] arr, int n, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++) minHeap.add(arr[i]);
        for(int i=k;i<n;i++){
            if(minHeap.peek()<arr[i]){
                minHeap.remove();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.peek();
    }
}