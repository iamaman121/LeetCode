class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> prevRow = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();
        for(int row=0; row<numRows; row++){
            List<Integer> currRow = new ArrayList<>(prevRow);
            currRow.add(1);
            for(int col=currRow.size()-2; col>0; col--){
                currRow.set(col, currRow.get(col)+currRow.get(col-1));
            }
            rows.add(currRow);
            prevRow = currRow;
        }
        return rows;
    }
}