class Pair{
    int r;
    int c;
    
    Pair(int x, int y){
        this.r= x;
        this.c= y;
    }
}
class Solution {
    int[] dir= new int[]{0,-1,0,1,0};
    public int orangesRotting(int[][] grid) {
        int r= grid.length, c= grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j));
                }
            }
        }
        int time= 0;
        while(!q.isEmpty()){
            int siz= q.size();
            while(siz-->0){
                Pair rem= q.remove();
                for(int i=0;i<4;i++){
                    int x= rem.r +dir[i], y= rem.c+ dir[i+1];
                    if(x<0 || x>=r || y<0 || y>=c || grid[x][y]!=1) continue;
                    grid[x][y]= 2;
                    q.add(new Pair(x, y));
                }
            }
            if(!q.isEmpty()) time++;
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}