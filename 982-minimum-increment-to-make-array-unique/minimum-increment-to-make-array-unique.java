class Solution {
    public int minIncrementForUnique(int[] nums) {
        int maxm= nums[0], n= nums.length, totalIncrement= 0;
        for(int i=1;i<n;++i){
            maxm= Math.max(maxm, nums[i]);
        }
        int[] freqCount= new int[n+maxm];
        for(int i=0;i<n;++i){
            freqCount[nums[i]]++;
        }
        for(int i=0;i<freqCount.length;++i){
            if(freqCount[i]<2) continue;
            totalIncrement+= freqCount[i]-1;
            freqCount[i+1]+= freqCount[i]-1;
        }
        return totalIncrement;
    }
}