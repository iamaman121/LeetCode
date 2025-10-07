class Solution {
    public int[] singleNumber(int[] nums) {
        int xor= 0;
        for(int num: nums){
            xor^= num;
        }
        int i=0;
        for(;i<32;i++){
            if((xor&(1<<i))!=0){
                break;
            }
        }
        int x= 0;
        for(int num: nums){
            if((num&(1<<i))!=0){
                x^= num;
            }
        }
        return new int[]{x, xor^x};
    }
}