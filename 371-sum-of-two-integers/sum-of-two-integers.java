class Solution {
    public int getSum(int a, int b) {
        int ans=0, carry=0, mask = 0xFFFFFFFF;
        for(int i=0;i<32;i++){
            int aBit= (a>>i)&1;
            int bBit= (b>>i)&1;
            int cBit= aBit^bBit^carry;
            carry= (aBit+bBit+carry)>=2?1:0;
            if(cBit!=0) ans|= (1<<i);
        }
        // if (ans > 0x7FFFFFFF) {
        // ans = ~(ans ^ mask);
        // }
        return ans;
    }
}