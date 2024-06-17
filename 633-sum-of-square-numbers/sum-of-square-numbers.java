class Solution {
    public boolean judgeSquareSum(int c) {
        for(int a=0;a<=(int)Math.sqrt(c);a++){
            int b= (int)Math.sqrt(c-a*a);
            if(a*a+b*b==c) return true;
        }
        return false;
    }
}