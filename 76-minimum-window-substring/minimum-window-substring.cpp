class Solution {
public:
    void addToVec(vector<int> &alp, char ch, int val){
        if(ch>='a' && ch<='z'){
            alp[ch-'a']+=val;
        }
        else if(ch>='A' && ch<='Z'){
            alp[26+(ch-'A')]+=val;
        }
        return;
    }
    string minWindow(string s, string t) {
        vector<int> alp(52);
        for(char ch: t){
            addToVec(alp, ch, 1);
        }

        int j=0, ans=1e9, idx=-1;
        for(int i=0; i< (int)s.size(); ++i){
            addToVec(alp, s[i], -1);
            int cnt=52;
            while(cnt==52){
                cnt=0;
                for(int a=0;a<52;++a){
                    if(alp[a]<=0) ++cnt;
                }
                if(cnt==52){
                    if(ans>i-j+1){
                        ans=i-j+1;
                        idx=j;
                    }
                    addToVec(alp, s[j++], +1);
                }
            }
        }
        return ans==1e9?"":s.substr(idx,ans);
    }
};