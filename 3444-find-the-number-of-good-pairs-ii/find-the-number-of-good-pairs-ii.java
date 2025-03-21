class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int[] cnt= new int[1000001];
        for(int num: nums2) cnt[num]++;
        long ans= 0;
        for(int num: nums1){
            if(num%k>0) continue;
            num/=k;
            for(int i=1;i*i<=num;i++){
                if(num%i>0) continue;
                if(i*i<num){
                    ans+= (long)cnt[num/i];
                }
                ans+= (long)cnt[i];
            }
        }
        return ans;
    }
}