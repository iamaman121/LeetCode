class Solution {
public:
    int characterReplacement(string s, int k) {
        int n= (int)s.length(), lo=0, hi=0, ans=0;
        vector<int> alp(26);
        while(hi<n){
            alp[s[hi]-'A']++;
            int clen=0;
            for(int i=0;i<26;++i){
                clen=max(clen, alp[i]);
            }
            if(hi-lo+1-clen<=k){
                ans=max(ans, hi-lo+1);
            }
            else{
                while(hi-lo+1-clen>k){
                    alp[s[lo++]-'A']--;
                    clen=0;
                    for(int i=0;i<26;++i){
                        clen=max(clen, alp[i]);
                    }    
                }
                ans=max(ans, hi-lo+1);
            }
            ++hi;
        }
        return ans;
    }
};