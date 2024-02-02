class Solution {
public:
    vector<int> sequentialDigits(int lo, int hi) {
        vector<int> ans;
        int curr;
        for(int nod=to_string(lo).size(); nod<=to_string(hi).size();++nod){
            for(int sv=1;sv<=10-nod;++sv){
                curr=0;
                for(int i=0;i<nod;++i){
                    curr=curr*10+(sv+i);
                }
                if(curr>=lo && curr<=hi) ans.push_back(curr);
            }
        }
        return ans;
    }
};