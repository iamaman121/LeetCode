class MinStack {
    Stack<Long> stk = new Stack<>();
    long minm;
    public MinStack() {
        
    }
    
    public void push(int value) {
        long val= value;
        if(stk.isEmpty() || minm<=val){
            if(stk.isEmpty()) minm= val;
            stk.push(val);
        }
        else{
            stk.push(2*val-minm);
            minm=val;
        }
    }
    
    public void pop() {
        if(stk.peek()>minm){
            stk.pop();
        }
        else{
            minm= 2*minm-stk.peek();
            stk.pop();
        }
    }
    
    public int top() {
        return (int)Math.max(minm,stk.peek());
    }
    
    public int getMin() {
        return (int)minm;
    }
}
