class Solution {
    private boolean checkPalindrome(String str){
        int sp= 0, ep= str.length()-1;
        while(sp<ep){
            if(str.charAt(sp)!=str.charAt(ep)) return false;
            sp++; ep--;
        }
        return true;
    }
    public int longestPalindrome(String s, String t) {
        int n= s.length(), m= t.length(), ans=0;
        String temp;
        for(int i=0;i<n;i++){
            for(int j=i;j<=n;j++){
                for(int x=0;x<m;x++){
                    for(int y=x;y<=m;y++){
                        temp= s.substring(i,j)+t.substring(x,y);
                        if(checkPalindrome(temp)){
                            ans= Math.max(ans, temp.length());
                        }
                    }
                }
            }
        }
        return ans;
    }
}