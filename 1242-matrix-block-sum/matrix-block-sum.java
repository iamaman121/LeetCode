class Solution {
    public int[][] matrixBlockSum(int[][] A, int k) {
        int n= A.length, m= A[0].length;
        int[][] ans= new int[n][m];
        //precompute A
        for(int j=1;j<m;j++) A[0][j]+= A[0][j-1];
        for(int i=1;i<n;i++) A[i][0]+= A[i-1][0];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                A[i][j]+= A[i-1][j]+A[i][j-1]-A[i-1][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]+= A[Math.min(n-1,i+k)][Math.min(m-1,j+k)];
                if(i-k>0) ans[i][j]-= A[i-k-1][Math.min(m-1,j+k)];
                if(j-k>0) ans[i][j]-= A[Math.min(n-1,i+k)][j-k-1];
                if(i-k>0 && j-k>0) ans[i][j]+= A[i-k-1][j-k-1];
            }
        }
        return ans;
    }
}