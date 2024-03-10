class Solution {
public:
    int climbStairs(int n) {
        int a=1, b=2, c=3;
        for(int i=2;i<=n;++i){
            i<n?(c=a+b):c=0;
            a=b, b=c;
        }
        return a;
    }
};