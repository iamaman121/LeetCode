class Solution {
public:
    int numStepsHelper(string s, int idx, int carry){
        if(idx==0){
            if(carry) return 1;
            else return 0;
        }
        int num= (s[idx]-'0')+carry;
        carry= num/2;
        num= num%2;
        if(num==0) return 1+ numStepsHelper(s, idx-1, carry);
        else return 2+ numStepsHelper(s, idx-1, 1);
    }
    int numSteps(string s) {
        int idx= (int)s.length()-1, carry= 0;
        return numStepsHelper(s, idx, carry);
    }
};