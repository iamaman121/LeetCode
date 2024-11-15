class Solution {
    public int mySqrt(int n) {
        int lo = 1 , hi = n, mid, ans = 0;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            if(mid<=n/mid){
                if(mid>ans) ans = mid;
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return ans;
    }
}