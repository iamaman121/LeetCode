class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->freq.get(a)-freq.get(b));
        for(Integer key:freq.keySet()){
            heap.add(key);
            if(heap.size()>k) heap.remove();
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = heap.remove();
        }
        return ans;
    }
}