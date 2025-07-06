class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramsMap = new HashMap<>();
        char[] currArr; String currStr;
        for(String str:strs){
            currArr = str.toCharArray(); Arrays.sort(currArr);
            currStr = new String(currArr);
            List<String> anagrams = anagramsMap.getOrDefault(currStr, new ArrayList<>());
            anagrams.add(str);
            anagramsMap.put(currStr, anagrams);
        }
        List<List<String>> ans = new ArrayList<>(anagramsMap.values());
        return ans;
    }
}