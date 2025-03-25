class Solution {
    public int getSum(int a, int b) {
        int ans=0, carry=0;
        for(int i=0;i<32;i++){
            int aBit= (a>>i)&1;
            int bBit= (b>>i)&1;
            int cBit= aBit^bBit^carry;
            carry= (aBit+bBit+carry)>=2?1:0;
            ans|= cBit<<i;
        }
        return ans;
    }
}