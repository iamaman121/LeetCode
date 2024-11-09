class Solution {
    private static double pow(double x, long n){
        if(n==0) return 1.0;
        double ans=(n%2==1)?x:1.0;
        double temp= pow(x,n/2);
        return ans*temp*temp;
    }
    public double myPow(double x, int n) {
        if(n<0){
            return pow(1.0/x, -1*(long)n);
        }
        else{
            return pow(x, (long)n);
        }
    }
}