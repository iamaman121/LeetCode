class Solution {
    
    private void generateParenthesisUtil(int op, int cl, int n, StringBuilder sb, List<String> ans){
        if(cl==n){
            ans.add(sb.toString());
            return;
        }
        if(op==cl){
            sb.append('(');
            generateParenthesisUtil(op+1, cl, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            if(op<n){
                sb.append('(');
                generateParenthesisUtil(op+1, cl, n, sb, ans);
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(')');
            generateParenthesisUtil(op, cl+1, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        generateParenthesisUtil(0, 0, n, sb, ans);
        return ans;
    }
}