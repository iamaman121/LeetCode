class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> pascalRow= new ArrayList<>(List.of(1));
        List<List<Integer>> pascalTriangle= new ArrayList<>();
        pascalTriangle.add(new ArrayList<>(pascalRow));
        for(int row=2;row<=numRows;row++){
            pascalRow.add(0,1);
            for(int j=1;j<pascalRow.size()-1;j++){
                pascalRow.set(j, pascalRow.get(j)+pascalRow.get(j+1));
            }
            pascalTriangle.add(new ArrayList<>(pascalRow));
        }
        return pascalTriangle;
    }
}