class Solution {
public:
    void rotate(vector<vector<int>>& arr) {
        int n= (int)arr.size();
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                swap(arr[i][j],arr[j][i]);
            }
        }
        for(int i=0;i<n/2;++i){
            for(int j=0;j<n;++j){
                swap(arr[j][i],arr[j][n-1-i]);
            }
        }
    }
};