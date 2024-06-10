class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascalArray = new ArrayList<>();
        for(int i=0;i<n;++i){
            List<Integer> cArr= new ArrayList<>();
            cArr.add(1);
            // pascalArray.add(Arrays.asList(1));
            int curr;
            for(int j=1;j<=i;++j){
                curr= (cArr.get(j-1)*(i-j+1))/j;
                cArr.add(curr);
            }
            pascalArray.add(cArr);
        }
        return pascalArray;
    }
}