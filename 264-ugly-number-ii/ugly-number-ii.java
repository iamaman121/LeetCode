class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly= new int[n];
        ugly[0]=1; 
        int j=1, m2=0, m3=0, m5=0;
        while(j<n){
            int curr= Math.min(ugly[m2]*2,Math.min(ugly[m3]*3,ugly[m5]*5));
            if(curr==ugly[m2]*2) m2++;
            if(curr==ugly[m3]*3) m3++;
            if(curr==ugly[m5]*5) m5++;
            ugly[j++]= curr;
        }
        return ugly[n-1];
    }
}