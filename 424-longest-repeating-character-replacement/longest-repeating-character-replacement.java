class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        int[] alp = new int[26];
        int left=0;
        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            alp[ch-'A']++;
            int maxm=0;
            for(int i=0;i<26;i++) maxm= Math.max(maxm,alp[i]);
            int len= right-left+1, diff= len-maxm;
            while(diff>k){
                alp[s.charAt(left++)-'A']--;
                for(int i=0;i<26;i++) maxm= Math.max(maxm,alp[i]);
                len= right-left+1; diff= len-maxm;
            }
            ans= Math.max(ans,len);
        }
        return ans;
    }
}