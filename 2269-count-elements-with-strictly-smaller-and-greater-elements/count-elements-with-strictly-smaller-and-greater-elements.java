class Solution {
    public int countElements(int[] arr) {
        int n= arr.length, maxm= Integer.MIN_VALUE, minm= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxm) maxm= arr[i];
            if(arr[i]<minm) minm= arr[i];
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i]>minm && arr[i]<maxm) count++;
        }
        return count;
    }
}