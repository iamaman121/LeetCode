#define add push_back

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& arr) {
        int n=arr.size(),m=arr[0].size();
        vector<int> lis;
    int left=0,right=m-1;
    int top=0,btm=n-1;
    int dir=0;
    while(top<=btm && left<=right){
        if(dir==0){
            for(int x=left;x<=right;++x){
                //                     System.out.println(arr[top][x]);
                lis.add(arr[top][x]);
            }
            ++top;
        }
        else if(dir==1){
            for(int x=top;x<=btm;++x){
                //                     System.out.println(arr[x][right]);
                lis.add(arr[x][right]);
            }
            --right;
        }
        else if(dir==2){
            for(int x=right;x>=left;--x){
                //                     System.out.println(arr[btm][x]);
                lis.add(arr[btm][x]);
            }
            --btm;
        }
        else if(dir==3){
            for(int x=btm;x>=top;--x){
                //                     System.out.println(arr[x][left]);
                lis.add(arr[x][left]);
            }
            ++left;
        }
        dir=(dir+1)%4;
    }
    return lis;
    }
};