class Solution {
    public boolean isPalindrome(String s) {
        int sp = 0, ep = s.length()-1;
        while(sp<ep){
            if(!ok(s.charAt(sp))){
                sp++;
                continue;
            }
            else if(!ok(s.charAt(ep))){
                ep--;
                continue;
            }
            char ch1 = s.charAt(sp), ch2 = s.charAt(ep);
            if(ch1==ch2 || isEqual(ch1, ch2)){
                sp++; ep--;
            }
            else return false;
            
        }
        return true;
    }
    private static boolean ok(char ch){
        return ((ch>=65 && ch<=90) || (ch>=97 && ch<=122) || (ch>=48 && ch<=57));
    }
    private static boolean isEqual(char a, char b){
        if(a>=65 && a<=90){
            a= (char)(a+32);
        }
        if(b>=65 && b<=90){
            b= (char)(b+32);
        }
        return a==b;
    }
}