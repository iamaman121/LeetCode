class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            hash[ch1-'a']++; hash[ch2-'a']--;
        }
        for(int i=0;i<26;i++){
            if(hash[i]!=0) return false;
        }
        return true;
    }
}