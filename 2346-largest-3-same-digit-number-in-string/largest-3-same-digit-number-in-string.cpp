class Solution {
public:
    string largestGoodInteger(string num) {
        int hi=-1;
        for(int i=0;i<= (int)num.length()-3;++i){
            if(num[i]==num[i+1] && num[i]==num[i+2]){
                if(hi<num[i]-'0') hi= num[i]-'0';
            }
        }
        if(hi<0) return "";
        else{
            string str(3,'0'+hi);
            return str;
        }
    }
};