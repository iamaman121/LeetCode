public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r=0, l=31, ans=0;
        while(l>r){
            int right= 1<<r, left= 1<<l;
            if((left&n)!=0){
                ans+= right;
            }
            if((right&n)!=0){
                ans+=left;
            }
            l--;
            r++;
        }
        if(l==r) ans+=(1<<l);
        return ans;

    }
}