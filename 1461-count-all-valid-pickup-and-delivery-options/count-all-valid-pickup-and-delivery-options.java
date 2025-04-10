class Solution {
    int MOD= (int)1e9+7;
    public int countOrders(int n) {
        long ans=1, res;
        for(int i=n;i>0;i--){
            res= (i*(2*i-1))%MOD;
            ans=(ans*res)%MOD;
        }
        return (int)ans;
    }
}