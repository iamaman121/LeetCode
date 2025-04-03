class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int n= nums.length;
        int[][] arr= new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]= nums[i];
            arr[i][1]= i;
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        int l= 0, r= nums.length-1, sum= 0;
        while(l<r){
            sum= arr[l][0]+arr[r][0];
            if(sum>tar) --r;
            else if(sum<tar) ++l;
            else{
                return new int[]{arr[l][1],arr[r][1]};
            }
        }
        return null;
    }
}