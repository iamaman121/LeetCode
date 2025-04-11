class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children= new TrieNode[26];
        isEnd= false;
    }
}
class Solution {
    
    private void insertWord(String word, TrieNode curr){
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']= new TrieNode();
            } 
            curr= curr.children[ch-'a'];
        }
        curr.isEnd= true;
    }
    public boolean wordBreak(String s, List<String> dict) {
        TrieNode root = new TrieNode();
        TrieNode curr;
        for(String word: dict){
            insertWord(word, root);
        }
        int n= s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=0;i<n;i++){
            if(dp[i]==false) continue;
            int j=i;
            curr= root;
            while(j<n && curr.children[s.charAt(j)-'a']!=null){
                curr= curr.children[s.charAt(j)-'a'];
                if(curr.isEnd){
                    dp[j+1]= true;
                }
                j++;
            }
        }
        return dp[n];
    }
}