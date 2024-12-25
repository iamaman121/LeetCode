class Solution {
    public String mergeAlternately(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        char[] ch = new char[n+m];
        int p1 = 0, p2 = 0;
        for(int i=0;i<n+m;i++){
            if(p1==n){
                ch[i] = w2.charAt(p2++);
            }
            else if(p2==m){
                ch[i] = w1.charAt(p1++);
            }
            else if(i%2==0){
                ch[i] = w1.charAt(p1++);
            }
            else{
                ch[i] = w2.charAt(p2++);
            }
        }
        return "".valueOf(ch);
    }
}