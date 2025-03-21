class Solution {
    long mod = 1000000007;
    private long pow(long x,int n){
        long res=1;
        while(n>0){
            if(n%2==1) res= (res*x)%mod;
            n/=2;
            x= (x*x)%mod;
        }
        return res;
    }
    public int sumSubseqWidths(int[] nums) {
        long ans=0;
        int n= nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            ans=((pow(2,i)*(long)nums[i])%mod+ans)%mod;
            ans=(ans-(pow(2,n-i-1)*(long)nums[i])%mod);
            if(ans<0) ans+=mod; 
        }
        return (int)ans;
    }
}