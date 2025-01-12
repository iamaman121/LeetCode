class Solution {
public:
    vector<vector<int>> generate(int n) {
        vector<vector<int>> pascalTriangle(n);
        vector<int> row;
        for(int i=1;i<=n;i++){
            row.push_back(1);
            for(int j=i-2;j>0;j--){
                row[j]+=row[j-1];
            }
            pascalTriangle[i-1]= row;
        }
        return pascalTriangle;
    }
};