class Solution {
    public int divide(int A, int B) {
        long a= A, b= B;
        int sign= 1;
        if(a<0){
            sign*= -1;
            a= -a;
        }
        if(b<0){
            sign*= -1;
            b= -b;
        }
        long q= 0, temp= 0;
        for(int i=31;i>=0;i--){
            long val= b<<i;
            if(temp+val<=a){
                temp+= val;
                q+= 1L<<i;
            }
        }
        if(sign<0) q*= -1;
        if(q> Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(q< Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)q;
    }
}