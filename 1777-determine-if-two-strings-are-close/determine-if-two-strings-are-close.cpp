class Solution {
public:
    bool closeStrings(string w1, string w2) {
        vector<int> alp(26);
        vector<int> blp(26);
        for(int i=0;i<(int)w1.size();++i){
            alp[w1[i]-'a']++;
        }
        for(int i=0;i<(int)w2.size();++i){
            blp[w2[i]-'a']++;
        }
        bool ans=false;
        for(int i=0;i<26;++i){
            ans=false;
            if(alp[i]==blp[i]){
                ans=true;
            }
            else if(alp[i]!=0 && blp[i]!=0){
                for(int j=i+1;j<26;++j){
                    if(alp[j]==blp[i]){
                        ans=true;
                        swap(alp[i],alp[j]);
                        break;
                    }
                }
            }
            if(ans==false) return false;
        }
        return true;
    }
};