class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int j = 0, n = pushed.length;
        for(int i=0;i<n;i++){
            stk.push(pushed[i]);
            while(j<n && stk.isEmpty()==false && popped[j]==stk.peek()){
                j++;
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}