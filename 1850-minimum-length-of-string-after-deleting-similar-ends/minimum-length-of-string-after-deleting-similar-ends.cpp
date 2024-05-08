class Solution {
public:
    int minimumLength(string s) {
        int beg= 0, end= (int)s.length()-1;
        while(beg<end && s[beg]==s[end]){
            while(beg+1<end && s[beg+1]==s[beg]) ++beg;
            while(end-1>beg && s[end-1]==s[end]) --end;
            ++beg; --end;
        }
        return end-beg+1;
    }
};