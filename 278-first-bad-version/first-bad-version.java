/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo= 1, hi= n, mid;
        while(lo<hi){
            System.out.println(lo+" "+hi);
            mid=lo+((hi-lo)>>1);
            boolean isBad= isBadVersion(mid);
            if(isBad) hi= mid;
            else{
                lo= mid+1;
            }
        }
        return lo;
    }
}