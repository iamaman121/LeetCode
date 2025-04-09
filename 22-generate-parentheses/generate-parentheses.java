class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Arrays.asList(""));
        dp.add(Arrays.asList("()"));
        for(int i=2;i<=n;i++){
            dp.add(new ArrayList<>());
            int inn= i-1, out=0;
            while(out<i){
                for(String inner : dp.get(inn)){
                    for(String outer : dp.get(out)){
                        StringBuilder sb= new StringBuilder();
                        sb.append('(');
                        sb.append(inner);
                        sb.append(')');
                        sb.append(outer);
                        dp.get(i).add(sb.toString());
                    }
                }
                inn--; out++;
            }
        }
        return dp.get(n);
    }
}