class Solution {
    private int getLen(int lft, int rgt, String s){
        while(lft>=0 && rgt<s.length() && s.charAt(lft)==s.charAt(rgt)){
            lft--; rgt++;
        }
        return rgt-lft-1;
    }
    public String longestPalindrome(String s) {
        int[] ans= new int[]{0,0};
        for(int i=0;i<s.length();i++){
            //odd length
            int oddLen= getLen(i,i,s);
            if(oddLen>ans[1]-ans[0]+1){
                int dist= oddLen/2;
                ans[0]= i-dist;
                ans[1]= i+dist;
            }
            //even length
            int evenLen= getLen(i,i+1,s);
            if(evenLen>ans[1]-ans[0]+1){
                int dist= evenLen/2 -1;
                ans[0]= i-dist;
                ans[1]= i+1+dist;
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
}