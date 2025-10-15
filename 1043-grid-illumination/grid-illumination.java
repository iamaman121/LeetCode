class Solution {
    Set<Long> activeLamps;
    Map<Integer,Integer> row;
    Map<Integer,Integer> col;
    Map<Integer,Integer> diag;
    Map<Integer,Integer> revDiag;
    int[] dir= {-1,0,1};
    private void deleteLamp(int r, int c){
        long lamp= getLamp(r,c);
        if(activeLamps.contains(lamp)){
            activeLamps.remove(lamp);
            row.put(r, row.get(r)-1);
            col.put(c, col.get(c)-1);
            diag.put(r-c, diag.get(r-c)-1);
            revDiag.put(r+c, revDiag.get(r+c)-1);
        }
    }
    private long getLamp(long r, long c){
        long lamp= (long)(1e9+1);
        return r*lamp+c;
    }
    private void addLamp(int r, int c){
        long lamp= getLamp(r,c);
        if(activeLamps.contains(lamp)){
            return;
        }
        activeLamps.add(lamp);
        row.put(r, row.getOrDefault(r,0)+1);
        col.put(c, col.getOrDefault(c,0)+1);
        diag.put(r-c, diag.getOrDefault(r-c,0)+1);
        revDiag.put(r+c, revDiag.getOrDefault(r+c,0)+1);
    }
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        activeLamps= new HashSet<>();
        row= new HashMap<>(); col= new HashMap<>();
        diag= new HashMap<>();
        revDiag= new HashMap<>();
        for(int[] lamp: lamps){
            int r= lamp[0], c= lamp[1];
            addLamp(r, c);
        }//
        int nq= queries.length, i=0;
        int[] ans= new int[nq];
        for(int[] q: queries){
            int r= q[0], c= q[1];
            if(row.getOrDefault(r,0)>0 || col.getOrDefault(c,0)>0 || diag.getOrDefault(r-c,0)>0 || revDiag.getOrDefault(r+c,0)>0){
                ans[i]=1;
            }
            else{
                ans[i]=0;
            }
            i++;
            for(int dr: dir){
                for(int dc: dir){
                    int nr= r+dr, nc= c+dc;
                    deleteLamp(nr,nc);
                }
            }
            
        }
        return ans;
    }
}