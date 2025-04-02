class Trie {
    TrieNode root;
    public Trie() {
        root= new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(curr.child[ch-'a']==null){
                curr.child[ch-'a']= new TrieNode();
            }
            curr= curr.child[ch-'a'];
        }
        curr.endOfWord= true;
    }
    
    public boolean search(String word) {
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(curr.child[ch-'a']==null){
                return false;
            }
            curr= curr.child[ch-'a'];
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String word) {
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(curr.child[ch-'a']==null){
                return false;
            }
            curr= curr.child[ch-'a'];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] child= new TrieNode[26];
    boolean endOfWord= false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */