class TrieNode{
    TrieNode[] child= new TrieNode[26];
    boolean isEnd= false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root= new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr= root;
        for(char ch: word.toCharArray()){
            if(curr.child[ch-'a']==null){
                curr.child[ch-'a']= new TrieNode();
            }
            curr= curr.child[ch-'a'];
        }
        curr.isEnd= true;
    }
    private boolean searchUtil(String word, int pos, TrieNode curr){
        if(pos==word.length()){
            return curr.isEnd;
        } 
        char ch= word.charAt(pos);
        if(ch!='.'){
            return curr.child[ch-'a']!=null && searchUtil(word, pos+1, curr.child[ch-'a']);
        }
        else{
            for(int i=0;i<26;i++){
                if(curr.child[i]!=null && searchUtil(word, pos+1, curr.child[i])) return true;
            }
            return false;
        }
    }
    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */