class Solution {
    private long nCr(int n, int r){
        r= Math.min(r, n-r);
        long ans=1;
        for(int i=1;i<=r;i++){
            ans=(ans*(n-i+1))/i;
        }
        return ans;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            result.add((int)nCr(rowIndex, i));
        }
        return result;
    }
}