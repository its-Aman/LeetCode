class TrieNode {
  public children: Map<string, TrieNode>;
  isEnd: boolean;
  
  constructor(isEnd = false){
    this.children = new Map<string, TrieNode>();
    this.isEnd = isEnd;
  }
}

class WordDictionary {
    root: TrieNode;

    constructor() {
      this.root = new TrieNode();
    }

    addWord(word: string): void {
      let curr = this.root;
      
      for(let c of word){
        if(!curr.children.has(c))
          curr.children.set(c, new TrieNode());

        curr = curr.children.get(c);
      }
      curr.isEnd = true;
    }

    search(word: string): boolean {
      let curr = this.root;

      return dfs(curr, 0);

      function dfs(node: TrieNode, i: number) {
        if(i == word.length)
          return node.isEnd;
        
        if(word.charAt(i) == '.')
          for(let [key, val] of node.children.entries())
            if(dfs(val, i + 1))
              return true;
        
        if(node.children.has(word.charAt(i)))
          return dfs(node.children.get(word.charAt(i)), i + 1);
        
        return false;
      }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */