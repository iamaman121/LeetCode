class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans=0, temp;
        for(int i=0;i<32;++i){
            if(n&(1<<i)){
                ans|=(1LL<<(31-i));
            }
        }
        return ans;
    }
};