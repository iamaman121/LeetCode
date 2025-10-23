class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> store;
    List<Integer> list;
    Random r;

    public RandomizedCollection() {
        store= new HashMap<>();
        list= new ArrayList<>();
        r= new Random();
    }
    
    public boolean insert(int val) {
        boolean ans= false;
        HashSet<Integer> set= store.getOrDefault(val, new HashSet<>()); 
        if(set.size()==0) ans= true;
        set.add(list.size()); list.add(val);
        store.put(val, set);
        return ans;
    }
    
    public boolean remove(int val) {
        if(store.containsKey(val)== false) return false;
        int lastIdx= list.size()-1, lastVal= list.get(lastIdx);
        if(lastVal==val){
            store.get(val).remove(lastIdx);
            if(store.get(val).isEmpty()) store.remove(val);
            list.remove(lastIdx);
        }
        else{
            int idx = store.get(val).iterator().next();
            store.get(val).remove(idx);
            if(store.get(val).isEmpty()) store.remove(val);
            store.get(lastVal).remove(lastIdx);
            store.get(lastVal).add(idx);
            list.set(idx, lastVal);
            list.remove(lastIdx);
        }
        return true;
    }
    
    public int getRandom() {
        return list.get(r.nextInt(0, list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */