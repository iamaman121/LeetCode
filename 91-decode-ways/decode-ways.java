class Solution {
    public int numDecodings(String s) {
        int n= s.length();
        int[] dp= new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int ch= s.charAt(i-1)-'0';
            if(ch>=1 && ch<=9) dp[i]= dp[i-1];
            if(i==1) continue;
            int cf= s.charAt(i-2)-'0';
            cf=cf*10+ch;
            if(cf<=26 && cf>=10) dp[i]+= dp[i-2];
        }
        return dp[n];
    }
}