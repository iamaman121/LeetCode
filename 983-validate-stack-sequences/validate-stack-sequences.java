class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i= 0, n= pushed.length, j= 0, m= popped.length;
        while(i<n && j<m){
            if(!stk.isEmpty() && stk.peek()==popped[j]){
                stk.pop();
                j++;
            }
            else{
                stk.push(pushed[i++]);
            }
        }
        while(j<m){
            if(!stk.isEmpty() && stk.peek()==popped[j]){
                stk.pop();
                j++;
            }
            else break;
        }
        return stk.isEmpty();
    }
}