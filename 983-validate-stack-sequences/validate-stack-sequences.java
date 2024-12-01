class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, pi = 0;
        Stack<Integer> stk = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            while(hs.contains(popped[i])==false){
                stk.push(pushed[pi]);
                hs.add(pushed[pi]);
                pi++;
            }
            if(stk.peek()==popped[i]){
                stk.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}