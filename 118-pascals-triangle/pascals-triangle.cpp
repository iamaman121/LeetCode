class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<int> pascalRow({1});
        vector<vector<int>> pascalTriangle(1,pascalRow);
        for(int i=2;i<=numRows;i++){
            pascalRow.push_back(1);
            for(int j=i-2;j>0;--j){
                pascalRow[j]+= pascalRow[j-1];
            }
            pascalTriangle.push_back(pascalRow);
        }
        return pascalTriangle;
    }
};