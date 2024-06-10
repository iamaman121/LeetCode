class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> cnt(110);
        for(int h: heights) cnt[h]++;
        int ans= 0, n= (int)heights.size();
        int idx=0, ptr=1;
        while(idx<n){
            while(cnt[ptr]==0) ++ptr;
            if(heights[idx]==ptr){
                ++idx; --cnt[ptr];
            }
            else{
                ++ans; ++idx; --cnt[ptr];
            }
        }
        return ans;
    }
};