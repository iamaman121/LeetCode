class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n+1];
        dp[0]= Arrays.asList("");
        dp[1]= Arrays.asList("()");
        for(int i=2;i<=n;i++){
            int inner=i-1, outer=0;
            dp[i]= new ArrayList<>();
            while(inner>=0){
                for(String in:dp[inner]){
                    for(String out:dp[outer]){
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(in);
                        sb.append(")");
                        sb.append(out);
                        dp[i].add(sb.toString());
                    }
                }
                inner--;outer++;
            }
        }
        return dp[n];
    }
}