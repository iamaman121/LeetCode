class MinStack {
    Stack<Long> stk;
    long minm;
    public MinStack() {
        stk = new Stack<>();
        minm= Integer.MAX_VALUE;
    }
    
    public void push(int v) {
        long val= v;
        if(stk.isEmpty()){
            stk.push(val);
            minm= val;
        }
        else{
            if(minm<=val){
                stk.push(val);
            }
            else{
                stk.push(2*val-minm);
                minm= val;
            }
        }
    }
    
    public void pop() {
        if(minm<stk.peek()){
            stk.pop();
        }
        else{
            minm= 2*minm-stk.pop();
        }
    }
    
    public int top() {
        long val;
        if(minm<=stk.peek()){
            val= stk.peek();
        }
        else{
            val= minm;
        }
        return (int)val;
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