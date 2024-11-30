class MinStack {
    Stack<Long> stk = new Stack<>();
    long minm; 
    public MinStack() {
        
    }
    
    public void push(int v) {
        long val = (long)v;
        if(stk.isEmpty()){
            minm = val;
            stk.push(val);
        }
        else{
            if(val>=minm){
                stk.push(val);
            }
            else{
                stk.push(2*val-minm);
                minm = val;
            }
        }
    }
    
    public void pop() {
        if(stk.peek()>=minm){
            stk.pop();
        }
        else{
            minm = 2*minm - stk.pop();
        }
    }
    
    public int top() {
        return (int)Math.max((long)stk.peek(),minm);
        
    }
    
    public int getMin() {
        return (int)minm;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */