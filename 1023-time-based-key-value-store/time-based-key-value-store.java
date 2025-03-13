class TimeMap {
    HashMap<String, TreeMap<Integer, String>> cache;
    public TimeMap() {
        cache= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!cache.containsKey(key)){
            cache.put(key, new TreeMap<>());
        }
        cache.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap= cache.get(key);
        if(treeMap==null) return "";
        // Map.Entry<Integer,String> entry = treeMap.floorEntry(timestamp);
        if(treeMap.floorKey(timestamp)==null) return "";
        int time= treeMap.floorKey(timestamp);
        return treeMap.get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */