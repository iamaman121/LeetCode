class Solution {
public:
    int lengthOfLastWord(string s) {
        int ed=(int)s.length()-1, ans=0;
        while(ed>=0 && s[ed]==' ') --ed;
        while(ed>=0 && s[ed]!=' ') ++ans, --ed;
        return ans;
    }
};