class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size()>1){
            int first = maxHeap.remove(), second = maxHeap.remove();
            if(first!=second){
                maxHeap.add(first-second);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}