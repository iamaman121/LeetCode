class Solution {
public:
    string longestPalindrome(string s) {
        int n= (int)s.length();
        int lps[n][n];
        memset(lps, 0, sizeof(lps));
        int ans=1, idx=0;
        for(int i=0;i<n;++i) lps[i][i]=1;
        for(int i=0;i<=n-2;++i){
            if(s[i]==s[i+1]){
                lps[i][i+1]=2;
                if(ans<lps[i][i+1]){
                    ans= lps[i][i+1];
                    idx=i;
                }
            }
        }
        for(int len=3;len<=n;++len){
            for(int i=0;i+len-1<n;++i){
                if(lps[i+1][i+len-2] && s[i]==s[i+len-1]){
                    lps[i][i+len-1]=max(lps[i][i+len-1], 2+lps[i+1][i+len-2]);
                }
                if(ans<lps[i][i+len-1]){
                    ans= lps[i][i+len-1];
                    idx=i;
                }
            }
        }
        return s.substr(idx, ans);
    }
};