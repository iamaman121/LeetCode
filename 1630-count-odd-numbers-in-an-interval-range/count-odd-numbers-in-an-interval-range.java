class Solution {
    private int countOdd(int n){
        if(n<=0) return 0;
        else return (n+1)/2;
    }
    public int countOdds(int low, int high) {
        return countOdd(high)- countOdd(low-1);
    }
}