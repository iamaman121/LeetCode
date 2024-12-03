class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n=ast.length, j=-1;
        boolean willAdd;
        for(int i=0;i<n;i++){
            if(ast[i]>0){
                ast[j+1] = ast[i];
                j++;
            }
            else{
                willAdd = true;
                while(j>=0 && ast[j]>0){
                    if(ast[j]<-ast[i]){
                        j--;
                    }
                    else if(ast[j]==-ast[i]){
                        j--;
                        willAdd= false;
                        break;
                    }
                    else{
                        willAdd= false;
                        break;
                    }
                }
                if(willAdd){
                    ast[j+1] = ast[i];
                    j++;
                }
            }
        }
        int[] ans = new int[j+1];
        for(int i=j;i>=0;i--) ans[i] = ast[i];
        return ans;
    }
}