class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxm= -1, ans= 0, n= arr.length;
        for(int i=0;i<n;i++){
            maxm= Math.max(maxm, arr[i]);
            if(maxm==i) ans++;
        }
        return ans;
    }
}