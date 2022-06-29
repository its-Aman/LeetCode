class TrieNode {
  public children: Array<TrieNode>;
  public isEnd: boolean;

  constructor(isEnd = false){
    this.children = new Array<TrieNode>(26);
    this.isEnd = isEnd;
  }
}

class Trie {
  private root: TrieNode;
  
  constructor(){
    this.root = new TrieNode();    
  }
  
  public insert(word: string) {
    let curr = this.root;
    
    for(let c of word) {
      const code = c.charCodeAt(0) - 97;
      
      if(!curr.children[code])
        curr.children[code] = new TrieNode();
      
      curr = curr.children[code];
    }
    curr.isEnd = true;
  }

  public search(word: string): boolean {
    let curr = this.root;
    
    for(let c of word) {
      const code = c.charCodeAt(0) - 97;

      if(!curr.children[code])
        return false;
      
      curr = curr.children[code];
    }
    
    return curr.isEnd;
  }

  public startsWith(prefix: string): boolean {
    let curr = this.root;
    
    for(let c of prefix) {
      const code = c.charCodeAt(0) - 97;

      if(!curr.children[code])
        return false;
      
      curr = curr.children[code];
    }
    
    return true;
  }
}