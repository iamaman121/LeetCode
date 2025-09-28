class Solution {
    public int majorityElement(int[] nums) {
        int num=0, freq=0;
        for(int a: nums){
            if(freq==0){
                num= a;
                freq=1;
            }
            else{
                if(num==a) freq++;
                else freq--;
            }
        }
        if(freq>0) return num;
        return -1;
    }
}