class Solution {
public:
    vector<vector<int>> generate(int n) {
        vector<vector<int>> pascalTriangles(n);
        for(int i=0;i<n;++i){
            pascalTriangles[i].push_back(1);
            for(int j=1;j<=i;++j){
                int curr= (pascalTriangles[i][j-1]*(i-j+1))/j;
                pascalTriangles[i].push_back(curr);
            }
        }
        return pascalTriangles;
    }
};