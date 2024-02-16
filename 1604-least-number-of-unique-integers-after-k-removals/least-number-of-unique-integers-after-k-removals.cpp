class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
       unordered_map<int,int> ump;
       for(int a: arr) ump[a]++;
       multiset<int> mset;
       for(auto v: ump){
           mset.insert(v.second);
       } 
       for(int v: mset){
           if(v<=k){
               k-=v;
               mset.erase(mset.find(v));
           }
           else break;
       }
       return mset.size();
    }
};