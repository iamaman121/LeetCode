class TrieNode{
    TrieNode[] children;
    int isWord;
    public TrieNode(){
        children= new TrieNode[26];
        isWord= -1;
    }
}
class Solution {
    TrieNode root;
    int[] dir= {-1,0,1,0,-1};
    boolean[][] used= new boolean[12][12];
    List<String> ans;
    private void insert(String word, int idx) {
        TrieNode curr= root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']= new TrieNode();
            }
            curr= curr.children[ch-'a'];
        }
        curr.isWord= idx;
    }
    private void checkIfPresent(int r, int c, char[][] board, TrieNode curr, String[] words){
        if(curr.isWord!=-1){
            ans.add(words[curr.isWord]);
            curr.isWord=-1;
        }
        if(r<0 || r==board.length || c<0 || c==board[0].length || used[r][c]) return;
        char ch= board[r][c];
        if(curr.children[ch-'a']!=null){
            used[r][c]= true;
            for(int i=0;i<4;i++){
                checkIfPresent(r+dir[i],c+dir[i+1], board, curr.children[ch-'a'], words);
            }
            used[r][c]= false;
        }
        return;
    }
    public List<String> findWords(char[][] board, String[] words) {
        root= new TrieNode();
        ans= new ArrayList<>();
        for(int i=0;i<words.length;i++){
            insert(words[i], i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                checkIfPresent(i, j, board, root, words);
            }
        }
        
        return ans;
    }
}