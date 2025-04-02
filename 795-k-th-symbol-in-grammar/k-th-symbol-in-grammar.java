class Solution {
    public int kthGrammar(int n, int k) {
        int sz= 1<<(n-1), curr=0;
        while(sz!=1){
            if(k>sz/2){
                k-=sz/2;
                curr= 1-curr;
            }
            sz/=2;
        }
        return curr;
    }
}