class Solution {
    public int trap(int[] ht) {
        int n= ht.length;
        int[] lft= new int[n];
        int[] rgt= new int[n];
        for(int i=0;i<n;i++){
            if(i==0) lft[i]=ht[i];
            else lft[i]=Math.max(ht[i],lft[i-1]);
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                rgt[i]=ht[i];
            }
            else{
                rgt[i]=Math.max(ht[i],rgt[i+1]);
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+= Math.min(lft[i],rgt[i])-ht[i];
        }
        return ans;
    }
}