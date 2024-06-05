class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<int> alp(26, 100), blp(26);
        for(string w: words){
            for(char ch: w){
                blp[ch-'a']++;
            }
            for(int i=0;i<26;++i){
                alp[i]= min(alp[i],blp[i]);
                blp[i]=0;
            }
        }
        vector<string> ans;
        for(int i=0;i<26;++i){
            char ch= 'a'+i;
            // cout<<ch<<" "<<alp[i]<<endl;
            while(alp[i]--){
                
                ans.push_back(string(1, ch));
            }
            
        }
        return ans;
    }
};