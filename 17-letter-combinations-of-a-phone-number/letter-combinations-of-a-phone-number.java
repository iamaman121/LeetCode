class Solution {
    String[] letter= {"abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private void generateAllCombinations(String digits, int idx, StringBuilder sb, List<String> ans){
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }
        int val= digits.charAt(idx) - '2';
        for(char ch: letter[val].toCharArray()){
            sb.append(ch);
            generateAllCombinations(digits, idx+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        if(digits.length()>0){
            StringBuilder sb= new StringBuilder();
            generateAllCombinations(digits, 0, sb, ans);
        }
        return ans;
    }
}