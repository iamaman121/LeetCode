class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            freq.put(ch1,freq.getOrDefault(ch1,0)+1);
            freq.put(ch2,freq.getOrDefault(ch2,0)-1);
        }
        for(int value: freq.values()){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
}