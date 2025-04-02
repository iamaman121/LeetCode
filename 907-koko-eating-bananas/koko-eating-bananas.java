class Solution {
    
    private long calculateTime(int[] piles, int k){
        long time= 0;
        for(int i=0;i<piles.length;i++){
            time+= (long)(piles[i]/k);
            if(piles[i]%k>0) time++;
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo= 1, hi= piles[0], mid, ans= -1;
        for(int val:piles) if(val>hi) hi= val;
        while(lo<hi){
            mid= (lo+hi)/2;
            if(calculateTime(piles, mid)>h){
                lo= mid+1;
            }
            else hi=mid;
        }
        return lo;
    }
}