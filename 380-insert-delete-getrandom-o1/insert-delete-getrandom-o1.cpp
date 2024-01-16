class RandomizedSet {
public:
    vector<int> arr;
    unordered_map<int,int> ump;
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if(ump.find(val)==ump.end()){
            arr.push_back(val);
            ump[val]=arr.size()-1;
            return true;
        }
        else return false;
    }
    
    bool remove(int val) {
        if(ump.find(val)!=ump.end()){
            arr[ump[val]]=arr.back();
            ump[arr.back()]=ump[val];
            ump.erase(val);
            arr.pop_back();
            return true;
        }
        else return false;
    }
    
    int getRandom() {
        return arr[rand()%arr.size()];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */