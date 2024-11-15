class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n==1 || arr[0]!=arr[1]){
            return arr[0];
        }
        if(arr[n-1]!=arr[n-2]){
            return arr[n-1];
        }
        int lo = 2, hi = n-3, mid;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]==arr[mid-1]){
                mid--;
            }
            if(mid%2==0){
                lo = mid+2;
            }
            else{
                hi = mid-1;
            }
        }
        return -1;
    }
}