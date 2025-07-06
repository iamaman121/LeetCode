class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> freqDiff = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freqDiff.put(ch,freqDiff.getOrDefault(ch,0)+1);
            ch = t.charAt(i);
            freqDiff.put(ch,freqDiff.getOrDefault(ch,0)-1);
        }
        for(char ch : freqDiff.keySet()){
            if(freqDiff.get(ch)!=0) return false;
        }
        return true;
    }
}