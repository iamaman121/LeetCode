class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            freq.put(sch,freq.getOrDefault(sch,0)+1);
            freq.put(tch,freq.getOrDefault(tch,0)-1);
        }
        for(int value : freq.values()){
            if(value!=0) return false;
        }
        return true;
    }
}