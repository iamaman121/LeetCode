class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] isPrime= new boolean[n+1];
        for(int i=3;i<=n;i+=2) isPrime[i]= true;
        isPrime[2]= true;
        for(int i=3;i*i<=n;i+=2){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=2*i){
                    isPrime[j]= false;
                }
            }
        }
        int ans=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                ans++;
            }
        }
        return ans;
    }
}