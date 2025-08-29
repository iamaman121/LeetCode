class MinStack {
    Stack<Long> stk = new Stack<>();
    long minm;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push((long)val);
            minm= val;
        }
        else{
            long v= val;
            if(v<minm){
                stk.push(2*v-minm);
                minm= v;
            }
            else{
                stk.push(v);
            }
        }
    }
    
    public void pop() {
        if(stk.peek()<minm){
            minm= 2*minm-stk.pop();
        }
        else{
            stk.pop();
        }
    }
    
    public int top() {
        long ans= stk.peek();
        if(ans<minm) ans= minm;
        return (int)ans;
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