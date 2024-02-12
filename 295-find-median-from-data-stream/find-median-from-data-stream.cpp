class MedianFinder {
public:
    priority_queue<int, vector<int>, greater<int>> minHeap;
    priority_queue<int> maxHeap;
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        maxHeap.push(num);
        minHeap.push(maxHeap.top());
        maxHeap.pop();
        if(maxHeap.size()==minHeap.size()) return;
        maxHeap.push(minHeap.top());
        minHeap.pop();
    }
    
    double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double)(maxHeap.top()+minHeap.top())/(double)2.0;
        }
        else return maxHeap.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */