class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double temp = myPow(x, n/2);
        if(n%2==0){
			return temp * temp;
		}
		else{
            if(n<0) x= 1.0/x;
			return x * temp * temp;
		}
    }
}