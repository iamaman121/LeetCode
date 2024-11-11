class Solution {
    public String toLowerCase(String s) {
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i]>=65 && str[i]<=90){
                str[i] = (char)(str[i]+32);
            }
        }
        return "".valueOf(str);
    }
}