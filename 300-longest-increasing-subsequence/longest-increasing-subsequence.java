class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length, idx=0;
        int[] tmp= new int[n];
        tmp[0]= nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>tmp[idx]){
                tmp[++idx]= nums[i];
                continue;
            }
            int lo=0, hi= idx, mid, ans=0;
            while(lo<=hi){
                mid= (lo+hi)/2;
                if(tmp[mid]==nums[i]){
                    ans= mid; break;
                }
                else if(tmp[mid]>nums[i]){
                    ans= mid; hi= mid-1;
                }
                else{
                    lo= mid+1;
                }
            }
            tmp[ans]= nums[i];
        }
        return idx+1;
    }
}