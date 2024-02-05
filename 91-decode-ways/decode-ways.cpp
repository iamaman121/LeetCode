class Solution {
public:
    int getNum(string s){
        return (s[0]-'0')*10+(s[1]-'0');
    }
    int numDecodings(string s) {
        int n=(int)s.length();
        vector<int> dp(n+1);
        dp[0]=1;
        for(int i=1;i<=n;++i){
            if(s[i-1]>'0' && s[i-1]<='9') dp[i]=dp[i-1];
            if(i>=2){
                int num= getNum(s.substr(i-2,2));
                if(num>=10 && num<=26) dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
};