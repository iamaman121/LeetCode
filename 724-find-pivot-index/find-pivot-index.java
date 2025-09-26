class Solution {
    public int pivotIndex(int[] nums) {
        int n= nums.length;
        int[] pf= new int[n]; pf[0]= nums[0];
        for(int i=1;i<n;i++){
            pf[i]= pf[i-1]+nums[i];
        }
        if(pf[n-1]-pf[0]==0) return 0;
        for(int i=1;i<=n-2;i++){
            if(pf[i-1]==pf[n-1]-pf[i]) return i;
        }
        if(pf[n-2]==0) return n-1;
        return -1;
    }
}