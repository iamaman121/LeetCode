class Solution {
    public String reverseStr(String s, int k) {
        char str[] = s.toCharArray();
        int n = s.length(), sp , ep;
        for(int i=0;i<n;i+=2*k){
            sp=i; ep = Math.min(n-1,i+k-1);
            reversePartOfArray(str, sp, ep);
        }
        return String.valueOf(str);
    }
    private static void reversePartOfArray(char[] str, int sp, int ep){
        char temp;
        while(sp<=ep){
            temp = str[sp];
            str[sp] = str[ep];
            str[ep] = temp;
            ++sp; --ep;
        }
    }
}