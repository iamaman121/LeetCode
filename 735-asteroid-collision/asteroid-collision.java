class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int a: asteroids){
            boolean destroyed= false;
            while(!stk.isEmpty() && stk.peek()>0 && a<0){
                int ms= Math.abs(stk.peek()) , ma= Math.abs(a);
                if(ms<ma){
                    stk.pop();
                }
                else if(ms>ma){
                    destroyed= true;
                    break;
                }
                else{
                    stk.pop();
                    destroyed= true;
                    break;
                }
            }
            if(!destroyed) stk.add(a);
        }
        int len= stk.size();
        int[] arr = new int[len];
        for(int i=len-1;i>=0;i--){
            arr[i]= stk.pop();
        }
        return arr;
    }
}