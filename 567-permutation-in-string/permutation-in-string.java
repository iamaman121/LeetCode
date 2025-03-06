class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1= new int[26];
        int[] freq2= new int[26]; 
        int n1= s1.length(), n2= s2.length(),left=0;
        for(int i=0;i<n1;i++){
            freq1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<n2;i++){
            freq2[s2.charAt(i)-'a']++;
            if(i-left+1<n1) continue;
            if(i-left+1>n1){
                freq2[s2.charAt(left++)-'a']--;
            }
            boolean ans = true;
            for(int j=0;j<26;j++){
                if(freq1[j]!=freq2[j]){
                    ans= false;
                    break;
                }
            }
            if(ans) return true;
        }
        return false;
    }
}