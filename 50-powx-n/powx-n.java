class Solution {
    private double myPowUtil(double x, long n){
        if(n==0) return 1.0;
        double temp = myPowUtil(x, n/2);
        double res= temp * temp;
        if(n%2==1) res*= x;
        return res;
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x= 1.0/x;
            N=-N;
        }
        return myPowUtil(x, N);
    }
}