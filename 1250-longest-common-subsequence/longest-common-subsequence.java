class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1= text1.length(), n2= text2.length(), res;
        int[][] lcs= new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
                res= Math.max(lcs[i-1][j],lcs[i][j-1]);
                if(res>lcs[i][j]) lcs[i][j]= res;
            }
        }
        return lcs[n1][n2];
    }
}