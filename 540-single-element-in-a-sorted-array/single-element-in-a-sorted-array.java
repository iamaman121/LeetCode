class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-2]!=arr[n-1]) return arr[n-1];
        int lo = 1, hi = n-2, mid;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            else if(mid%2==1){
                if(arr[mid-1]==arr[mid]){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
            else{
                if(arr[mid+1]==arr[mid]){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}