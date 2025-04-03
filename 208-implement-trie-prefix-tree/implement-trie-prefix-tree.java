class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean isEnd= false;
}
class Trie {
    TrieNode root;

    public Trie() {
        root= new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr= root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode());
            }
            curr= curr.children.get(ch);
        }
        curr.isEnd= true;
    }
    
    public boolean search(String word) {
        TrieNode curr= root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }
            else{
                curr= curr.children.get(ch);
            }
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr= root;
        for(char ch: prefix.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }
            else{
                curr= curr.children.get(ch);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */