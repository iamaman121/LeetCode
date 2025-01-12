class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i=1;i<=n;i++){
            row.add(1);
            for(int j=i-2;j>0;j--){
                row.set(j, row.get(j-1)+row.get(j));
            }
            pascalTriangle.add(new ArrayList<>(row));
        }
        return pascalTriangle;
    }
}