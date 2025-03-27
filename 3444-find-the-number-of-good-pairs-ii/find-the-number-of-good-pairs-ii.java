class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int[] cnt2= new int[1000001];
        for(int x: nums2) cnt2[x]++;
        long ans=0;
        for(int val:nums1){
            if(val%k!=0) continue;
            val/=k;
            for(int i=1;i*i<=val;i++){
                if(val%i!=0) continue;
                ans+= (long)cnt2[i];
                if(i*i<val){   
                    ans+= (long)cnt2[val/i];
                }
            }
        }
        return ans;
    }
}