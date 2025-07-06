class Solution {
    private String sortString(String str){
        char[] currArr = str.toCharArray();
        Arrays.sort(currArr);
        return new String(currArr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramsMap = new HashMap<>();
        String currStr;
        for(String str:strs){ 
            currStr = sortString(str);
            List<String> anagrams = anagramsMap.getOrDefault(currStr, new ArrayList<>());
            anagrams.add(str);
            anagramsMap.put(currStr, anagrams);
        }
        List<List<String>> ans = new ArrayList<>(anagramsMap.values());
        return ans;
    }
}