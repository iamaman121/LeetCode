class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int[] cnt= new int[1000001];
        for(int x: nums2) cnt[x]++;
        Arrays.sort(nums2);
        int[] divcnt= new int[1000001];
        int prev=-1;
        for(int val:nums2){
            if(val==prev) continue;
            for(int j=val;j<=1000000;j+=val){
                divcnt[j]+= cnt[val];
            }
            prev= val;
        }
        long ans=0;
        for(int val:nums1){
            if(val%k!=0) continue;
            val/=k;
            ans+= (long)divcnt[val];
        }
        return ans;
    }
}