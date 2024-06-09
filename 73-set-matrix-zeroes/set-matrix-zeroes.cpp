class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int nr= (int)matrix.size(), nc= (int)matrix[0].size(), zeroRow=1;
        for(int i=0;i<nr;++i){
            for(int j=0;j<nc;++j){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    if(i==0){
                        zeroRow=0;
                    }
                    else matrix[i][0]=0;
                }
            }
        }
        for(int i=nr-1;i>=0;--i){
            for(int j=nc-1;j>=0;--j){
                if(i!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
                }
                else{
                    if(!zeroRow || matrix[0][j]==0) matrix[i][j]=0;
                }
            }
        }
    }
};