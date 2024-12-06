class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap, rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.size()==rightMinHeap.size()){
            rightMinHeap.add(num);
            leftMaxHeap.add(rightMinHeap.remove());
        }
        else{
            leftMaxHeap.add(num);
            rightMinHeap.add(leftMaxHeap.remove());
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size()==rightMinHeap.size()){
            return (leftMaxHeap.peek()+rightMinHeap.peek())/2.0;
        }
        else{
            return leftMaxHeap.peek()*1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */