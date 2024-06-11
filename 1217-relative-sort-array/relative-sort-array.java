class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt= new int[1001];
        for(int i=0;i<arr1.length;++i){
            cnt[arr1[i]]++;
        }
        int idx=0;
        for(int i=0;i<arr2.length;++i){
            while(cnt[arr2[i]]>0){
                arr1[idx++]= arr2[i];
                --cnt[arr2[i]];
            }
        }
        for(int i=0;i<=1000;++i){
            while(cnt[i]>0){
                arr1[idx++]= i;
                --cnt[i];
            }
        }
        return arr1;
    }
}