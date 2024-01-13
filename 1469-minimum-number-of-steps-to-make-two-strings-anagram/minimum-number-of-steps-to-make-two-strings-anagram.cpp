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
        int sum=0;
        for(int i=0;i<26;++i) sum+=abs(alp[i]);
        return sum/2;
    }
};