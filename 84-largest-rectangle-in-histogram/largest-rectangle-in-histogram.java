class Pair{
    int h, v;
    Pair(int h, int v){
        this.h= h;
        this.v= v;
    }
}
class Solution {
    public int largestRectangleArea(int[] ht) {
        int n= ht.length, ans=0;
        Stack<Pair> stk = new Stack<>();
        for(int i=0;i<n;i++){
            int idx= i;
            while(stk.size()>0 && stk.peek().h>ht[i]){
                Pair p= stk.pop();
                idx= p.v;
                ans= Math.max(ans, (i-idx)*p.h);
            }
            stk.push(new Pair(ht[i], idx));
        }
        while(stk.size()>0){
            Pair p= stk.pop();
            ans= Math.max(ans, (n-p.v)*p.h);
        }
        return ans;
    }
}