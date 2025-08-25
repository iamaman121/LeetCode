class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr= Arrays.asList(1);
        ans.add(curr);
        for(int i=1;i<numRows;i++){
            curr= new ArrayList<>(ans.get(i-1));
            curr.add(1);
            for(int j=curr.size()-2;j>0;j--){
                curr.set(j, curr.get(j)+curr.get(j-1));
            }
            ans.add(curr);
        }
        return ans;
    }
}