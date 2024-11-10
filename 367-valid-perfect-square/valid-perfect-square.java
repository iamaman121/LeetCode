class Solution {
    public boolean isPerfectSquare(int n) {
        int i=1;
        while(i<=n/i){
            ++i;
        }
        --i;
        return (i*i==n);
    }
}