class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                stk.push(asteroids[i]);
            }
            else{
                boolean willAdd= true;
                while(!stk.isEmpty() && stk.peek()>0){
                    if(stk.peek()<-asteroids[i]){
                        stk.pop();
                        continue;
                    }
                    else if(stk.peek()==-asteroids[i]){
                        stk.pop();
                        willAdd = false;
                        break;
                    }
                    else{
                        willAdd = false;
                        break;
                    }
                }
                if(willAdd){
                    stk.push(asteroids[i]);
                }
            }
        }
        int n = stk.size();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--) ans[i] = stk.pop();
        return ans;
    }
}