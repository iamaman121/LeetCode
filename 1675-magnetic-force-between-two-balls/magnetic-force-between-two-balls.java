class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int n= pos.length, lo= 0, hi= pos[n-1], mid, cnt, prev, ans=1;
        while(lo<=hi){
            mid= (lo+hi)>>1;
            cnt=1; prev= pos[0];
            for(int i=1;i<n;i++){
                if(pos[i]-prev>=mid){
                    ++cnt;
                    prev= pos[i];
                }
            }
            if(cnt>=m){
                ans= mid;
                lo= mid+1;
            }
            else{
                hi= mid-1;
            }
        }
        return ans;
    }
}