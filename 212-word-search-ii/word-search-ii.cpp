class Trie{
public:
    vector<Trie*> child= vector<Trie*>(26, NULL);
    bool isWord=false;

    Trie() {
        
    }
};
class Solution {
public:
    vector<string> ans;
    vector<int> dir= vector<int>({-1,0,1,0,-1});
    void insert(string word, Trie* curr) {
        for(int i=0;i<(int)word.size();++i){
            if(!curr->child[word[i]-'a']){
                curr->child[word[i]-'a']= new Trie();
            }
            curr= curr->child[word[i]-'a'];
        }
        curr->isWord=true;
    }
    void dfs(vector<vector<char>>& board, int r, int c, int m, int n, vector<vector<bool>> &vis, Trie* curr, string &str){
        if(curr && curr->isWord){
            ans.push_back(str);
            curr->isWord= false;
        } 
        if(!curr) return;
        if(r<0 || c<0 || r==m || c==n){
            return;
        }
        if(vis[r][c]) return;
        vis[r][c]=true;
        str.push_back(board[r][c]);
        if(curr->child[board[r][c]-'a']){
            for(int i=0;i<4;++i){
                int nr=r+dir[i], nc=c+dir[i+1];
                dfs(board, nr, nc, m, n, vis, curr->child[board[r][c]-'a'], str);
            }
        }
        str.pop_back();
        vis[r][c]=false;
        return;
    }
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie* curr= new Trie();
        for(string word: words){
            insert(word, curr);
        }
        int m= (int)board.size(), n=(int)board[0].size();
        vector<vector<bool>> vis(m, vector<bool>(n));
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                string str= "";
                dfs(board, i, j, m, n, vis, curr, str);
            }
        }
        return ans;
    }
};