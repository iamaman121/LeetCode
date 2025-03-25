class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t right= 1, left= 1L<<31, ans=0;
        // left= left<<31;
        while(left>right){
            if((left&n)>0){
                ans|=right;
            }
            if((right&n)>0){
                ans|=left;
            }
            left/=2;
            right*=2;
        }
        if((left&n)>0){
            ans|=right;
        }
        return ans;
    }
};