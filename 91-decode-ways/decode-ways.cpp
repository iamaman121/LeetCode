class Solution {
public:
    int numDecodings(string s) {
        int len = (int)s.size();
        vector<int> dways(len+3);
        dways[len]=1;
        for(int i=len-1; i>=0; --i){
            if(s[i] != '0'){
                dways[i]=dways[i+1];
                if(i+1<len){
                    int val= (s[i]-'0')*10 + (s[i+1]-'0');
                    if(val<=26 && val>=10) dways[i]+=dways[i+2];
                }
            }
            // else{
            //     dways[i]=dways[i+2];
            // }
        }
        return dways[0];
    }
};