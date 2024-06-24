class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        int n= (int)nums.size(), csum= 0, ans=0;
        vector<int> changeBits(n+1);
        for(int i=0;i<n;i++){
            csum+= changeBits[i];
            nums[i]= (nums[i]+csum)%2;
            if(nums[i]) continue;
            else{
                ++ans;
                csum++;
                if(i+k<=n) changeBits[i+k]--;
                else return -1;
            }
        }
        return ans;
    }
};