class Solution {
    public String longestPalindrome(String s) {
        int idx=0, mlen=1, n= s.length();
        boolean[][] lps= new boolean[n][n];
        for(int i=0;i<n;i++) lps[i][i]= true;
        for(int i=0;i<=n-2;i++){
            if(s.charAt(i)!=s.charAt(i+1)) continue;
            lps[i][i+1]= true;
            if(mlen<2){
                mlen=2;
                idx=i;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                if(s.charAt(i)!=s.charAt(i+len-1) || !lps[i+1][i+len-2]) continue;
                lps[i][i+len-1]= true;
                if(mlen<len){
                    mlen=len;
                    idx=i;
                }
            }
        }
        return s.substring(idx, idx+mlen);
    }
}