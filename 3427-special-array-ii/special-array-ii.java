class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n= nums.length, qlen= queries.length;
        int[] pre= new int[n+1];
        for(int i=2;i<=n;i++){
            pre[i]=pre[i-1]+(nums[i-1]%2==nums[i-2]%2?0:1);
        }
        boolean[] ans= new boolean[qlen];
        for(int i=0;i<qlen;i++){
            int y= queries[i][1], x= queries[i][0];
            ans[i]= pre[y+1]-pre[x+1]==y-x;
        }
        return ans;
    }
}