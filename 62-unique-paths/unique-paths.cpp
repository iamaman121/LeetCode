class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m>n) swap(m,n);
        long int ans=1;
        for(int i=1;i<m;++i){
            ans*=(n+i-1);
            ans/=i;
        }
        return ans;
    }
};