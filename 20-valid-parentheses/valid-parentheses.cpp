class Solution {
public:
    bool isValid(string s) {
        unordered_map<char,char> mp;
        mp['(']= ')'; mp['{']= '}'; mp['[']= ']';
        stack<char> stk;
        for(char ch: s){
            if(mp.find(ch)==mp.end()){
                if(!stk.empty() && mp[stk.top()]==ch){
                    stk.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                stk.push(ch);
            }
        }
        return stk.empty();
    }
};