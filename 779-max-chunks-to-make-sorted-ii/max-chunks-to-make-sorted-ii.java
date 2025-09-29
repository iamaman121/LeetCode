class Solution {
    private int[] getPrefixMax(int[] arr){
        int n= arr.length;
        int[] pref= new int[n];
        pref[0]= arr[0];
        for(int i=1;i<n;i++){
            pref[i]= Math.max(pref[i-1], arr[i]);
        }
        return pref;
    }
    private int[] getSuffixMin(int[] arr){
        int n= arr.length;
        int[] suff= new int[n];
        suff[n-1]= arr[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]= Math.min(suff[i+1], arr[i]);
        }
        return suff;
    }
    public int maxChunksToSorted(int[] arr) {
        int[] prefixMax= getPrefixMax(arr);
        int[] suffixMin= getSuffixMin(arr);
        int n= arr.length, count= 0;
        for(int i=0;i<n-1;i++){
            if(prefixMax[i]<=suffixMin[i+1]){
                count++;
            }
        }
        count++;
        return count;
    }
}