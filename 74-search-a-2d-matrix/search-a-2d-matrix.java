class Solution {
    public boolean searchMatrix(int[][] A, int target) {
        int m= A.length, n= A[0].length;
        int low= 0, high= m*n-1, mid;
        while(low<=high){
            mid= low+(high-low)/2;
            int row= mid/n, col= mid%n;
            int val=A[row][col];
            if(val>target){
                high= mid-1;
            }
            else if(val<target){
                low= mid+1;
            }
            else return true;
        }
        return false;
    }
}