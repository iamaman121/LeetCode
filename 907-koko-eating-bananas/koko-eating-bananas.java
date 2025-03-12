class Solution {
    private long findTime(int val, int[] pile){
        int res=0;
        for(int p: pile){
            res+= p/val;
            if(p%val>0) res++;
        }
        return res;
    }
    public int minEatingSpeed(int[] pile, int h) {
        int n=pile.length;
        int low=0, high=1, mid, ans=-1;
        for(int i=0;i<n;i++){
            high= Math.max(high,pile[i]);
            low+= pile[i]/h;
        }
        while(low<=high){
            mid= low+(high-low)/2;
            if(mid>0 && findTime(mid, pile)<=h){
                ans= mid;
                high=mid-1;
            }
            else low=mid+1;
        } 
        return ans;
    }
}