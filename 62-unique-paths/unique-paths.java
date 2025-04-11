class Solution {
    public int uniquePaths(int m, int n) {
        if(m<n){
            int temp= m;
            m= n; n= temp;
        }
        long ans=1;
        for(int i=1;i<n;i++){
            ans=(ans*(m+i-1))/i;
        }
        return (int)ans;
    }
}