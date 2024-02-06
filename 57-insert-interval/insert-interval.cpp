class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& vals, vector<int>& nVal) {
        int n=(int)vals.size();
        if(n==0){
            vals.push_back(nVal);
            return vals;
        }
        else if(vals[0][0]>nVal[1]){
            vals.insert(vals.begin()+0, nVal);
            return vals;
        }
        else if(vals[n-1][1]<nVal[0]){
            vals.push_back(nVal);
            return vals;
        }
        for(int i=0;i<n;++i){
            if(nVal[0]<=vals[i][1]){
                vals.insert(vals.begin()+i, nVal);
                break;
            }
        }
        for(int i=1;i<=n;++i){
            if(vals[i][0]<=vals[i-1][1]){
                vals[i-1][0]=min(vals[i-1][0], vals[i][0]);
                vals[i-1][1]=max(vals[i-1][1], vals[i][1]);
                vals.erase(vals.begin()+i);
                --i;
                --n;
            }
            
        }
        return vals;
    }
};