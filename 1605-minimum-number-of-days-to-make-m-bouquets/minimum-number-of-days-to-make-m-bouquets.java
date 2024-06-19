class Solution {
    public int minDays(int[] bDay, int m, int k) {
        int n= bDay.length, lo=1, hi=1, mid, curr, cnt=0;
        for(int i=0;i<n;++i) if(bDay[i]>hi) hi= bDay[i];
        if((long)n<(long)m*(long)k) return -1;
        while(lo<hi){
            mid= (lo+hi)>>1;
            curr= 0; cnt= 0;
            for(int i=0;i<n;++i){
                if(bDay[i]<=mid) ++curr;
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
                hi=mid;
            }
        }
        return lo;
    }
}