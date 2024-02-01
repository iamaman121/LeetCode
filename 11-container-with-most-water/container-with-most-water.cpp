class Solution {
public:
    int maxArea(vector<int>& ht) {
        int lo=0, hi=(int)ht.size()-1, ans=0;
        while(lo<hi){
            ans=max(ans,min(ht[lo],ht[hi])*(hi-lo));
            if(ht[lo]<ht[hi]) ++lo;
            else --hi;
        }
        return ans;
    }
};