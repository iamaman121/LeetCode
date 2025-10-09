class Pair{
    int elem, index;
    Pair(int elem, int index){
        this.elem= elem;
        this.index= index;
    }
}
class Solution {
    private void merge(Pair[] arr, int[] cnt, int s, int m, int e){
        int i= s, j= m+1, k= 0;
        Pair[] tmp= new Pair[e-s+1];
        int rightCount= 0;
        while(i<=m && j<=e){
            if(arr[i].elem<=arr[j].elem){
                cnt[arr[i].index]+= rightCount;
                tmp[k++]= arr[i++];
            }
            else{
                rightCount++;
                tmp[k++]= arr[j++];
            }
        }
        while(i<=m){
            cnt[arr[i].index]+= e-m;
            tmp[k++]= arr[i++];
        }
        while(j<=e){
            tmp[k++]= arr[j++];
        }
        for(i=s;i<=e;i++){
            arr[i]= tmp[i-s];
        }
    }
    private void mergeSort(Pair[] arr, int[] cnt, int s, int e){
        if(s>=e) return;
        int m= (s+e)/2;
        mergeSort(arr, cnt, s, m);
        mergeSort(arr, cnt, m+1, e);
        merge(arr, cnt, s, m, e);
    }
    public List<Integer> countSmaller(int[] nums) {
        int n= nums.length;
        int[] cnt= new int[n];
        Pair[] arr= new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]= new Pair(nums[i], i);
        }
        mergeSort(arr, cnt, 0, n-1);
        List<Integer> ans= new ArrayList<>();
        for(int c: cnt){
            ans.add(c);
        }
        return ans;
    }
}