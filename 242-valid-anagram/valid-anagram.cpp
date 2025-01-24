class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()) return false;
        vector<int> freq(26);
        for(int i=0;i<s.length();i++){
            freq[s[i]-'a']++;
            freq[t[i]-'a']--;
        }
        for(int val : freq){
            if(val!=0) return false;
        }
        return true;
    }
};