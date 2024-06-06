#define hand nums
class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int groupSize) {
        multiset<int> st;
        for(int h: hand) st.insert(h);
        while(!st.empty()){
            int n= groupSize;
            int prev= *st.begin()-1;
            while(n--){
                if(st.empty()) return false;
                if(st.find(1+prev)!=st.end()){
                    ++prev;
                    st.erase(st.find(prev));
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
};