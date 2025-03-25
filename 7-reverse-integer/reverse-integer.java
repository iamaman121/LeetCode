class Solution {
    public int reverse(int x) {
        int ans=0;
        int sign= (x>=0)?1:-1;
        int maxm= Integer.MAX_VALUE, minm= Integer.MIN_VALUE;
        if(x==minm) return 0;
        if(sign==-1) x=-x;
        while(x!=0){
            int val= x%10;
            // if(sign==-1) val=10-val;
            x/=10;
            if(ans>(maxm-val)/10 || ans<(minm+val)/10){
                return 0;
            }
            ans=ans*10+sign*val;
        }
        return ans;
    }
}