class Solution {
    public int largestRectangleArea(int[] ht) {
        int n= ht.length;
        int[] pse= new int[n];
        int[] nse= new int[n];
        Stack<Integer> stk= new Stack<>();
        //NSE
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && ht[i]<ht[stk.peek()]){
                nse[stk.pop()]= i;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            nse[stk.pop()]= n;
        }
        //PSE
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && ht[i]<ht[stk.peek()]){
                pse[stk.pop()]= i;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            pse[stk.pop()]= -1;
        }
        int ans= 0;
        for(int i=0;i<n;i++){
            ans= Math.max(ans, ht[i]*(nse[i]-pse[i]-1));
        }
        return ans;
    }
}