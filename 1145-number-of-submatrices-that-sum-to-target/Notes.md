<h2>number-of-submatrices-that-sum-to-target Notes</h2><hr>class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& A, int tar) {
        int r= (int)A.size(), c= (int)A[0].size(), ans=0;
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                A[i][j]+= i>0?A[i-1][j]:0;
            }
        }
        
        unordered_map<int,int> ump;
        for(int a=0;a<r;++a){
            for(int b=a;b<r;++b){
                ump.clear();
                int csum=0;
                for(int j=0;j<c;++j){
                    csum+=A[b][j];
                    if(a>0) csum-=A[a-1][j];
                    if(ump.find(csum-tar)!=ump.end()) ans+=ump[csum-tar];
                    if(csum==tar){
                        ++ans;
                    }
                    ump[csum]++;
                }
            }
        }
        return ans;
    }
};