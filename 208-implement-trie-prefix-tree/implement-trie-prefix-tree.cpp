class Trie {
public:
    bool isWord= false;
    vector<Trie*> child= vector<Trie*>(26, NULL);

    Trie() {
        
    }
    
    void insert(string word) {
        Trie* curr= this;
        for(int i=0;i<(int)word.size();++i){
            if(!curr->child[word[i]-'a']){
                curr->child[word[i]-'a']= new Trie();
            }
            curr= curr->child[word[i]-'a'];
        }
        curr->isWord=true;
    }
    
    bool search(string word) {
        Trie* curr= this;
        for(int i=0;i<(int)word.size();++i){
            if(!curr->child[word[i]-'a']){
                return false;
            }
            curr= curr->child[word[i]-'a'];
        }
        return curr->isWord;
    }
    
    bool startsWith(string prefix) {
        Trie* curr= this;
        for(int i=0;i<(int)prefix.size();++i){
            if(!curr->child[prefix[i]-'a']){
                return false;
            }
            curr= curr->child[prefix[i]-'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */