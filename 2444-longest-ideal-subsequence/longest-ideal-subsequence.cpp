class Solution {
public:
    int longestIdealString(string s, int k) {
        vector<int> alp(26);
        for(int x=0;x<(int)s.length();++x){
            char ch=s[x];
            int val=ch-'a', temp=1;
            for(int i=max(0,val-k); i<=min(25,val+k); ++i){
                temp=max(temp, alp[i]+1);
            }
            alp[val]=temp;
            cout<<alp[val]<<" ";
        }
        cout<<"\n";
        int temp=0;
        for(int i=0;i<26;++i){
            cout<<alp[i]<<" ";
            temp=max(temp,alp[i]);
        }
        
        return temp;
    }
};