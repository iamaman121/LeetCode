class Solution {
    private int countSmallerOrEqual(int[] A, int val){
        int cnt=0;
        for(int x:A) if(x<=val) ++cnt;
        return cnt;
    }
    public int kthsmallest(int[] A, int k) {
        int lo= A[0], hi= A[0], mid;
        for(int val:A){
            if(lo>val) lo= val;
            if(hi<val) hi= val;
        }
        while(lo<=hi){
            mid= (lo+hi)/2;
            int cnt= countSmallerOrEqual(A, mid);
            if(cnt<k){
                lo= mid+1;
            }
            else{
                if(countSmallerOrEqual(A, mid-1)<k){
                    return mid;
                }
                else hi= mid-1;
            }
        }
        return -1;
    }
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
        return kthsmallest(nums, n+1-k);
    }
}