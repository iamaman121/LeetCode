class RandomizedSet {
    Map<Integer,Integer> store;
    List<Integer> arr;
    Random r; 
    public RandomizedSet() {
        store= new HashMap<>();
        arr= new ArrayList<>();
        r= new Random();
    }
    
    public boolean insert(int val) {
        if(store.containsKey(val)) return false;
        arr.add(val);
        store.put(val, arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(store.containsKey(val)==false) return false;
        int idx= store.get(val), last= arr.size()-1;
        if(idx!=last){
            int nval= arr.get(last);
            store.remove(val);
            arr.set(idx, nval);
            arr.remove(last);
            store.put(nval, idx);
        }
        else{
            store.remove(val);
            arr.remove(last);
        }
        return true;
    }
    
    public int getRandom() {
        return arr.get(r.nextInt(0, arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */