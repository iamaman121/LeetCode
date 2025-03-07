class Solution {
    private int calculate(int a, int b, String s){
        if(s.equals("+")) return a+b;
        else if(s.equals("-")) return a-b;
        else if(s.equals("*")) return a*b;
        else return a/b;
    }
    public int evalRPN(String[] tokens) {
        Set<String> sign = new HashSet<>(Arrays.asList("+","-","*","/"));
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String tkn= tokens[i];
            if(!sign.contains(tkn)){
                stk.push(Integer.valueOf(tkn));
            }
            else{
                int b=stk.pop(), a=stk.pop();
                stk.push(calculate(a,b,tkn));
            }
        }
        return stk.peek();
    }
}