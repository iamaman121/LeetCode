class Solution {
    public double myPow(double x, int n) {
        if(n==Integer.MIN_VALUE){
            return x*myPow(x,n+1);
        }
        double ans= pow(x, Math.abs(n));
        if(n<0) return 1.0/ans;
        else return ans;
    }
    private double pow(double x, int n){
        if(n==0) return 1.0;
        double ans= pow(x, n/2);
        ans= ans*ans;
        if(n%2==1) ans=ans*x;
        return ans;
    }
}