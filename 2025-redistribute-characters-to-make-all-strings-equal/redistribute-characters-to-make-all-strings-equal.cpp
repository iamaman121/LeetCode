class Solution {
public:
    bool makeEqual(vector<string>& words) {
        int n=(int) words.size();
        vector<int> alp(26);
        for(int i=0;i<n;++i){
            for(char ch:words[i]){
                alp[ch-'a']++;
            }
        }
        for(int i=0;i<26;++i){
            if(alp[i]%n) return false;
        }
        return true;
    }
};