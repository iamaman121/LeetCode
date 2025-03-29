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
    long multiply(long a, long b){
        return (a*b)%mod;
    }
    public int sumSubseqWidths(int[] nums) {
        long ans=0;
        int n= nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            ans=(ans+multiply(pow(2,i),nums[i]))%mod;
            ans=(ans-multiply(pow(2,n-i-1),nums[i])+mod)%mod;
        }
        return (int)ans;
    }
}