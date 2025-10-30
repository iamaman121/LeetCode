class Solution {
    private int[] nseRight(int[] ht){
        int n= ht.length;
        int[] nser= new int[n];
        Arrays.fill(nser, n);
        Stack<Integer> stk= new Stack<>();
        for(int i=0;i<n;i++){
            while(stk.size()>0 && ht[stk.peek()]>ht[i]){
                nser[stk.pop()]= i;
            }
            stk.push(i);
        }
        return nser;
    }
    private int[] nseLeft(int[] ht){
        int n= ht.length;
        int[] nsel= new int[n];
        Arrays.fill(nsel, -1);
        Stack<Integer> stk= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(stk.size()>0 && ht[stk.peek()]>ht[i]){
                nsel[stk.pop()]= i;
            }
            stk.push(i);
        }
        return nsel;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nseR= nseRight(heights);
        int[] nseL= nseLeft(heights);
        int ans= 0;
        for(int i=0;i<heights.length;i++){
            int leftIdx= nseL[i]+1, rightIdx= nseR[i]-1;
            int width= rightIdx-leftIdx+1;
            ans= Math.max(ans, width*heights[i]);
        }
        return ans;
    }
}