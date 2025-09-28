class Solution {
    public int majorityElement(int[] nums) {
        int num= nums[0], freq=1;
        for(int i=1;i<nums.length;i++){
            if(num==nums[i]) freq++;
            else{
                if(freq==0){
                    freq= 1;
                    num= nums[i];
                }
                else freq--;
            }
        }
        return num;
    }
}