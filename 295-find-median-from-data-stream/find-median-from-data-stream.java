class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        minHeap= new PriorityQueue<>();
        maxHeap= new PriorityQueue<>((a,b)-> b-a);
    }
    
    public void addNum(int num) {
        if(minHeap.size()==maxHeap.size()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        else return maxHeap.peek()*1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */