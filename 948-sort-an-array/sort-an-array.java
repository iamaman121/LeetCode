class Solution {
    Random rand;
    int r;
    public void quickSort(int[] arr, int low, int high) {
        if(low>=high) return;
        // code here
        int p= partition(arr, low, high);
        quickSort(arr, low, p-1);
        quickSort(arr, p+1, high);
    }
    private void swap(int[] arr, int i, int j){
        int tmp= arr[i];
        arr[i]= arr[j];
        arr[j]= tmp;
    }
    private int partition(int[] arr, int low, int high) {
        r= rand.nextInt(high-low+1)+low;
        swap(arr, high, r);
        int pivot= arr[high];
        int p1= low, p2= high-1;
        while(p1<=p2){
            if(arr[p1]<=pivot) p1++;
            else if(arr[p2]>pivot) p2--;
            else{
                swap(arr, p1, p2);
                p1++; p2--;
            }
        }
        swap(arr, high, p1);
        return p1;
    }
    public int[] sortArray(int[] nums) {
        rand= new Random();

        quickSort(nums, 0, nums.length-1);
        return nums;
    }
}