class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int>alp(26);
        for(char ch:s) alp[ch-'a']++;
        for(char ch:t) alp[ch-'a']--;
        for(int i=0;i<26;++i){
            if(alp[i]) return false;
        }
        return true;
    }
};