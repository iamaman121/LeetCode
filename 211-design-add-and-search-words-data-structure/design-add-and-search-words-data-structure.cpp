class WordDictionary {
public:
    bool isWord= false;
    vector<WordDictionary*> child= vector<WordDictionary*>(26, NULL);

    WordDictionary() {
        
    }
    
    void addWord(string word) {
        WordDictionary* curr= this;
        for(int i=0;i<(int)word.size();++i){
            if(!curr->child[word[i]-'a']){
                curr->child[word[i]-'a']= new WordDictionary();
            }
            curr= curr->child[word[i]-'a'];
        }
        curr->isWord=true;
    }
    bool search(WordDictionary* curr, string word, int idx) {
        if(idx==word.size()){
            if(curr) return curr->isWord;
            else return false;
        } 
        else if(curr==NULL) return false;
        if(word[idx]=='.'){
            bool ans=false;
            for(int i=0;i<26;++i){
                if(curr->child[i]!=NULL){
                    ans = ans || search(curr->child[i], word, idx+1);
                }
            }
            return ans;
        }
        else{
            if(!curr->child[word[idx]-'a']){
                return false;
            }
            curr= curr->child[word[idx]-'a'];
            return search(curr, word, idx+1);
        }
    }
    bool search(string word) {
        WordDictionary* curr= this;
        return search(curr, word, 0);
        
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */