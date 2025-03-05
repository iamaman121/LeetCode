class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> store = new HashMap<>();
        char[] word;
        for(int i=0;i<strs.length;i++){
            word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = Arrays.toString(word);
            if(store.containsKey(key)){
                store.get(key).add(strs[i]);
            }
            else{
                store.put(key, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        return new ArrayList<>(store.values());
    }
}