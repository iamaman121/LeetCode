class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex+1);
        if(rowIndex<0) return row;
        row.add(1);
        for(int i=1;i<=rowIndex;i++){
            row.add((int)(((long)row.get(i-1)*(rowIndex-i+1))/i));
        }
        return row;
    }
}