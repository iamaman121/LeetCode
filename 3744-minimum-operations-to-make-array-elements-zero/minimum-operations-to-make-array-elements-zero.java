class Solution {
    public long minOperations(int[][] queries) {
        long val[]= new long[17];
        val[0]=1;
        for(int i=1;i<=16;i++){
            val[i]= val[i-1]*4L;
            // System.out.print(val[i]+" ");
        }
        long ans=0, curr=0;
        for(int[] q: queries){
            long l= q[0], r= q[1];
            curr=0;
            for(int i=0;i<=15;i++){
                if(l>=val[i+1]) continue;
                else if(r<val[i]) break;
                if(r<val[i+1]){
                    curr+= (r-l+1)*(i+1);
                    break;
                }
                else{
                    curr+= (val[i+1]-l)*(i+1);
                    l=val[i+1];
                }
            }
            ans+= curr/2 + curr%2;
        }
        return ans;
    }
}