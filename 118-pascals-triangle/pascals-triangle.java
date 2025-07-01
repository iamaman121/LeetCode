class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> curr;
        for(int i=1;i<=numRows;i++){
            curr= new ArrayList<>(prev);
            curr.add(1);
            for(int j=i-2;j>0;j--){
                curr.set(j, curr.get(j)+curr.get(j-1));
            }
            ans.add(curr);
            prev= curr;
        }
        return ans;
    }
}