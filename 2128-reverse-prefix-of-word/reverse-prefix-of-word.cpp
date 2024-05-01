class Solution {
public:
    string reversePrefix(string word, char ch) {
        int a=0, idx=0;
        for(int i=0;i<(int)word.length();++i){
            if(word[i]==ch){
                idx=i;
                break;
            }
        }
        while(a<idx){
            swap(word[a++],word[idx--]);
        }
        return word;
    }
};