class Solution {
    private int extract(int left, int right, String s){
        int res=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            res++;
            left--; right++;
        }
        return res;
    }
    public int countSubstrings(String s) {
        int ans= 0;
        for(int i=0;i<s.length();i++){
            //oddlength;
            ans+= extract(i,i,s);
            //evenlength;
            ans+= extract(i,i+1,s);
        }
        return ans;
    }
}