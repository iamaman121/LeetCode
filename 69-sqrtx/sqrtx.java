class Solution {
    public int mySqrt(int n) {
        int ans=1;
        while(ans<=n/ans){
            ++ans;
        }
        return ans-1;
    }
}