class Solution {
    private long findTime(int[] piles, int k){
        long time= 0;
        for(int i=0;i<piles.length;i++){
            time+= (long)(piles[i]/k);
            if(piles[i]%k>0) time++;
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        int low=1, high= piles[0];
        for(int i=0;i<n;i++) high= Math.max(high, piles[i]);
        int ans= high;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(findTime(piles, mid)<=(long)h){
                ans= mid;
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }
}