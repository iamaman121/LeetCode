class Solution {
    private  void reverse(int[] arr, int s, int e){
		while(s<e){
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++; e--;
		}
	}
	private  void rotate(int[] arr, int n, int k){
		reverse(arr, 0, n-1);
		reverse(arr, 0, k-1);
		reverse(arr, k, n-1);
	}
    public void rotate(int[] arr, int k) {
        int n= arr.length;
        k= k%n;
		rotate(arr, n, k);
    }
}