class Solution {
public:
    bool isPalindrome(string s){
        int lo=0, hi=(int)s.length()-1;
        while(lo<hi){
            if(s[lo]!=s[hi]) return false;
            ++lo, --hi;
        }
        return true;
    }
    string firstPalindrome(vector<string>& words) {
        for(string word: words){
            if(isPalindrome(word)) return word;
        }
        return "";
    }
};