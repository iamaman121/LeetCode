class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> curr= new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> newRow= new ArrayList<>(curr);
            newRow.add(1);
            for(int j=i-2;j>0;j--){
                newRow.set(j, newRow.get(j)+newRow.get(j-1));
            }
            curr= newRow;
            ans.add(curr);
        }
        return ans;
    }
}