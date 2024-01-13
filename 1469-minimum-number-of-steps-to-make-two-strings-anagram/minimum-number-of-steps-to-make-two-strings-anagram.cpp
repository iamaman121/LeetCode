class Solution {
public:
    int minSteps(string s, string t) {
        vector<int> alp(26);
        for(char ch: s){
            alp[ch-'a']++;
        }
        for(char ch: t){
            alp[ch-'a']--;
        }
        int count=0;
        for(int i=0;i<26;++i) count+= alp[i]>0?alp[i]:0;
        return count;
    }
};