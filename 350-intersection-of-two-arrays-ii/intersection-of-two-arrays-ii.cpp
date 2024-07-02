class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<int> res;
        int ptr1= 0, ptr2= 0, n= (int)nums1.size(), m= (int)nums2.size();
        while(ptr1<n && ptr2<m){
            if(nums1[ptr1]==nums2[ptr2]){
                res.push_back(nums1[ptr1]);
                ++ptr1, ++ptr2;
            }
            else if(nums1[ptr1]<nums2[ptr2]){
                ++ptr1;
            }
            else ++ptr2;
        }
        return res;
    }
};