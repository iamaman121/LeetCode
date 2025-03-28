class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] ans= new int[]{-1,-1};
        if(right<2) return ans;
        int n= right;
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
        int prev=-1;
        for(int i=left;i<=right;i++){
            if(isPrime[i]){
                if(prev!=-1){
                    if(ans[0]==-1 || ans[1]-ans[0]>i-prev){
                        ans[0]= prev;
                        ans[1]= i;
                    }
                }
                prev= i;
            }
        }

        return ans;
    }
}