class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int[] cnt= new int[1000001];
        int[] div= new int[1000001];
        for(int num: nums2) cnt[num]++;
        Arrays.sort(nums2);
        for(int i=0;i<nums2.length;i++){
            if(i==0 || nums2[i]!=nums2[i-1]){
                for(int j=nums2[i];j<=1000000;j+=nums2[i]){
                    div[j]+= cnt[nums2[i]];
                }
            }
        }
        long ans= 0;
        for(int num: nums1){
            if(num%k>0) continue;
            num/=k;
            ans+= (long)div[num];
            // for(int i=1;i*i<=num;i++){
            //     if(num%i>0) continue;
            //     if(i*i<num){
            //         ans+= (long)cnt[num/i];
            //     }
            //     ans+= (long)cnt[i];
            // }
        }
        return ans;
    }
}