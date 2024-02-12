class MedianFinder {
public:
    priority_queue<int, vector<int>, greater<int>> minHeap;
    priority_queue<int> maxHeap;
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        maxHeap.push(num);
        while(maxHeap.size()>1+minHeap.size()){
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        }
        while(!maxHeap.empty() && !minHeap.empty()){
            if(maxHeap.top()<=minHeap.top()) break;
            int val1= maxHeap.top(), val2= minHeap.top();
            maxHeap.pop(), minHeap.pop();
            maxHeap.push(val2);
            minHeap.push(val1);
        }
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