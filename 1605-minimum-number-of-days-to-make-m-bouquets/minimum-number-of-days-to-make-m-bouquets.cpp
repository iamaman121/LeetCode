class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int lo= 1, hi= 1, n= (int)bloomDay.size();
        int mid, ans=-1, curr=0, cnt=0;
        for(int i=0;i<n;++i){
            hi= max(hi, bloomDay[i]);
        }
        while(lo<=hi){
            mid= (lo+hi)>>1;
            curr= 0, cnt= 0;
            for(int i=0;i<n;++i){
                if(bloomDay[i]<=mid) ++curr;
                else curr=0;
                if(curr==k){
                    curr=0;
                    ++cnt;
                }
            }
            if(cnt<m){
                lo= mid+1;
            }
            else{
                ans= mid;
                hi= mid-1;
            }
        }
        return ans;
    }
};