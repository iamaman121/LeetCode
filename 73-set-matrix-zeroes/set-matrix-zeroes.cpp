class Solution {
public:
    void setZeroes(vector<vector<int>>& A) {
        int m= (int)A.size(), n= (int)A[0].size();
        int row=1;
        for(int i=0;i<n;++i){
            if(A[0][i]==0){
                row=0;
            }
        }
        for(int i=1;i<m;++i){
            for(int j=0;j<n;++j){
                if(A[i][j]==0){
                    A[i][0]=0;
                    A[0][j]=0;
                }
            }
        }
        for(int i=m-1;i>0;--i){
            for(int j=n-1;j>=0;--j){
                if(A[i][0]==0 || A[0][j]==0) A[i][j]=0;
            }
        }
        if(!row){
            for(int j=n-1;j>=0;--j) A[0][j]=0;
        }
    }
};