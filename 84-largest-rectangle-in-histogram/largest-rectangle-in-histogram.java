class Solution {
    public int largestRectangleArea(int[] ht) {
        int n= ht.length, ans= 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<=n;i++){
            int temp= 0;
            if(i<n) temp= ht[i];
            while(stk.size()>0 && temp<ht[stk.peek()]){
                int tbs= stk.pop();
                int nsr= i, nsl= -1;
                if(stk.size()>0) nsl= stk.peek();
                int width= (nsr-1)-(nsl+1)+1;
                ans= Math.max(ans, ht[tbs]*width);
            }
            stk.push(i);
        }
        return ans;
    }
}