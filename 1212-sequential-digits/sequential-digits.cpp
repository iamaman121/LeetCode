class Solution {
public:
    vector<int> sequentialDigits(int lo, int hi) {
        vector<int> ans;
        int lDig=0, hDig=0, l=lo, r=hi;
        while(l>0){
            ++lDig;
            l/=10;
        }
        while(r>0){
            ++hDig;
            r/=10;
        }
        string temp;
        int curr;
        for(int nod=lDig; nod<=hDig;++nod){
            for(int sv=1;sv<=10-nod;++sv){
                temp="";
                for(int i=0;i<nod;++i){
                    temp+=(char)('0'+sv+i);
                }
                curr=stoi(temp);
                if(curr>=lo && curr<=hi) ans.push_back(curr);
            }
        }
        return ans;
    }
};