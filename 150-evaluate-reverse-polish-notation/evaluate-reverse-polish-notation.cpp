class Solution {
public:
    bool isMul(string s){
        return s=="+" || s=="-" || s=="*" || s=="/";
    }
    int op(int a, int b, string s){
        if(s=="+") return a+b;
        if(s=="-") return a-b; 
        if(s=="*") return a*b; 
        else return a/b; 
    }
    int evalRPN(vector<string>& tokens) {
        int a,b;
        stack<int> stk;
        for(auto s: tokens){
            if(isMul(s)){
                b=stk.top();
                stk.pop();
                a=stk.top();
                stk.pop();
                stk.push(op(a,b,s));
            }
            else{
                stk.push(stoi(s));
            }
        }
        return stk.top();
    }
};