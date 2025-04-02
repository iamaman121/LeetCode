class Solution {
    private int calculateDays(int[] wts, int cap){
        int days=1, curr=cap;
        for(int wt: wts){
            if(wt>curr){
                curr= cap-wt;
                days++;
            } 
            else{
                curr-=wt;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int d) {
        int lo=1, hi=0, mid;
        for(int wt: weights){
            hi+= wt;
            if(lo<wt) lo= wt;
        }
        while(lo<hi){
            mid= (lo+hi)/2;
            if(calculateDays(weights, mid)>d){
                lo= mid+1;
            }
            else hi= mid;
        }
        return lo;
    }
}