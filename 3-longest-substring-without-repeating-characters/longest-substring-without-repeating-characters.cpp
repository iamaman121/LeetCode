class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int lo=0, hi=0, n=(int)s.length(), ans=0;
        vector<int> vec(256,-1);
        while(hi<n){
            if(vec[s[hi]]==-1){
                vec[s[hi]]=hi;
            }
            else{
                int idx=vec[s[hi]];
                while(lo<=idx){
                    vec[s[lo++]]=-1;
                }
                vec[s[hi]]=hi;
            }
            ans=max(ans,hi-lo+1);
            ++hi;
        } 
        return ans;
    }
};