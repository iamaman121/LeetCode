class Solution {
    private int findTime(int val, int[] pile){
        int res=0;
        for(int p: pile){
            res+= p/val;
            if(p%val>0) res++;
        }
        return res;
    }
    public int minEatingSpeed(int[] pile, int h) {
        int n=pile.length;
        int low=1, high=Integer.MAX_VALUE, mid, ans=-1;
        while(low<=high){
            mid= low+(high-low)/2;
            if(findTime(mid, pile)<=h){
                ans= mid;
                high=mid-1;
            }
            else low=mid+1;
        } 
        return ans;
    }
}