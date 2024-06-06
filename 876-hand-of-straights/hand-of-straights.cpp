class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        multiset<int> st;
        for(int h: hand) st.insert(h);
        while(!st.empty()){
            int n= groupSize;
            int prev= *st.begin()-1;
            while(n--){
                if(st.empty()) return false;
                if(st.count(1+prev)){
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