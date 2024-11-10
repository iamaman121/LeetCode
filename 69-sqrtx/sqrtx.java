class Solution {
    public int mySqrt(int n) {
        int ans=1, pAns=0;
        while(ans<=n/ans){
            pAns=ans;
            ++ans;
        }
        return ans-1;
    }
}