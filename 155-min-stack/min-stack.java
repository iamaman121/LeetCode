class MinStack {
    Stack<Long> stk;
    long minm;
    public MinStack() {
        stk= new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            minm= (long)val;
            stk.push((long)val);
        }
        else{
            if((long)val>=minm){
                stk.push((long)val);
            }
            else{
                long value= val;
                stk.push(2*value-minm);
                minm= value;
            }
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) return;
        long value= stk.pop();
        if(value<minm){
            minm= 2*minm-value;
        }
    }
    
    public int top() {
        long value= stk.peek();
        return (int)Math.max(value, minm);
        // return (value<minm)?minm:value;
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