class Solution {
    public int largestRectangleArea(int[] ht) {
        int n= ht.length, ans=0;
        // [index, height]
        Stack<int[]> stk= new Stack<>();
        for(int i=0;i<n;i++){
            int pIdx=i;
            while(!stk.isEmpty() && stk.peek()[1]>ht[i]){
                ans= Math.max(ans,stk.peek()[1]*(i-stk.peek()[0]));
                pIdx= stk.peek()[0];
                stk.pop();
            }
            stk.push(new int[]{pIdx, ht[i]});
        }
        while(!stk.isEmpty()){
            ans= Math.max(ans,stk.peek()[1]*(n-stk.peek()[0]));
            stk.pop();
        }
        return ans;
    }
}