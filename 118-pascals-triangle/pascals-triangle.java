class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> curr;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            curr = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    curr.add(1);
                }
                else{
                    curr.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}