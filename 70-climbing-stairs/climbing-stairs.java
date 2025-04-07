class Solution {
    public int climbStairs(int n) {
        int f= 1, s= 1, temp;
        for(int i=2;i<=n;i++){
            s+= f; f=s-f;
        }
        return s;
    }
}