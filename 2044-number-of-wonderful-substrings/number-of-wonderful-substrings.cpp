#define ll long long
class Solution {
public:
    long long wonderfulSubstrings(string word) {
        int n= (int)word.size();
        unordered_map<int, int> ump;
        unordered_set<int> wfl;
        wfl.insert(0);
        for(int i=0; i<10; ++i){
            wfl.insert(1<<i);
        }

        ll ans=0;
        int mask= 0;
        for(int i=0; i<n; ++i){
            int val= word[i]-'a';
            mask^= 1<<val;
            ll cnt=0;
            if(wfl.count(mask)) ++cnt;
            for(int a: wfl){
                if(ump.count(a^mask)){
                    cnt+= (ll)ump[a^mask];
                }
            }
            // cout<<mask<<" "<<cnt<<"\n";
            ans+= cnt;
            ump[mask]++;
        }
        return ans;
    }
};