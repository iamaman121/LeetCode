class Solution {
    private int largestRectangleArea(int[] ht) {
        int n= ht.length, ans= 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<=n;i++){
            int temp= (i<n)?ht[i]:0;
            while(stk.size()>0 && ht[stk.peek()]>temp){
                int tbs= stk.pop();
                int nsr= i, nsl= -1; if(stk.size()>0) nsl= stk.peek();
                int width= nsr-nsl-1;
                ans= Math.max(ans, ht[tbs]*width);
            }
            stk.push(i);
        }
        return ans;
    }
    public int maximalRectangle(char[][] mat) {
        int n= mat.length, m= mat[0].length, maxArea= 0;
        int[] arr= new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='0') arr[j]=0;
                else arr[j]++;
            }
            maxArea= Math.max(maxArea, largestRectangleArea(arr));
        }
        return maxArea;
    }
}