class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character,Character> dict = new HashMap<>();
        dict.put('(',')'); dict.put('{','}'); dict.put('[',']');
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            }
            else{
                if(stk.isEmpty() || dict.get(stk.peek())!=ch){
                    return false;
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}