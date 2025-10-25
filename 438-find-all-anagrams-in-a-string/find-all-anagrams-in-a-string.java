class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList<>();
        if(s.length()<p.length()) return ans;
        int[] hms= new int[26];
        int[] hmp= new int[26];
        for(int i=0;i<p.length();i++){
            int ch= p.charAt(i)-'a';
            hmp[ch]++;
        }
        int matchCount= 0;
        for(int i=0;i<p.length()-1;i++){
            int ch= s.charAt(i)-'a';
            hms[ch]++;
            if(hms[ch]<=hmp[ch]) matchCount++;
        }
        for(int i=p.length()-1;i<s.length();i++){
            int ch= s.charAt(i)-'a', sp= i+1-p.length();
            hms[ch]++;
            if(hms[ch]<=hmp[ch]) matchCount++;
            if(matchCount==p.length()){
                ans.add(sp);
            }
            int ch2= s.charAt(sp)-'a';
            hms[ch2]--;
            if(hms[ch2]<hmp[ch2]) matchCount--;
        }
        return ans;
    }
}