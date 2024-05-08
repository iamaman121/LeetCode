class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int n= (int)score.size();
        unordered_map<int,int> uIdx;
        for(int i=0;i<n;++i){
            uIdx[score[i]]= i;
        }
        sort(score.rbegin(), score.rend());
        vector<string> relativeRanks(n);
        for(int i=0;i<n;++i){
            if(i>2){
                relativeRanks[uIdx[score[i]]]= to_string(i+1);
            }
            else if(i==0) relativeRanks[uIdx[score[i]]]= "Gold Medal";
            else if(i==1) relativeRanks[uIdx[score[i]]]= "Silver Medal";
            else relativeRanks[uIdx[score[i]]]= "Bronze Medal";
        }
        return relativeRanks;
    }
};