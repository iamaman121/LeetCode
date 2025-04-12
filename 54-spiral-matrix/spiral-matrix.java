class Solution {
    public List<Integer> spiralOrder(int[][] A) {
        List<Integer> res = new ArrayList<>();
        int top=0, btm=A.length-1, lft=0, rgt= A[0].length-1, dir=0;
        while(top<=btm && lft<=rgt){
            if(dir==0){
                for(int i=lft;i<=rgt;i++) res.add(A[top][i]);
                top++;
            }
            else if(dir==1){
                for(int i=top;i<=btm;i++) res.add(A[i][rgt]);
                rgt--;
            }
            else if(dir==2){
                for(int i=rgt;i>=lft;i--) res.add(A[btm][i]);
                btm--;
            }
            else{
                for(int i=btm;i>=top;i--) res.add(A[i][lft]);
                lft++;
            }
            dir= (dir+1)%4;
        }
        return res;
    }
}