class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int> count(3);
        for(int i=0;i<(int)nums.size();++i){
            count[nums[i]]++;
        }
        int idx=0, ptr=0;
        while(ptr<3){
            while(count[ptr]--){
                nums[idx++]= ptr;
            }
            ++ptr;
        }
    }
};