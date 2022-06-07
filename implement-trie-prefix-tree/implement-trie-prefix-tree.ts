class TrieNode {
  public children: Map<string, TrieNode>;
  public isEnd: boolean;
  public word: string;

  constructor(isEnd = false){
    this.children = new Map<string, TrieNode>();
    this.isEnd = isEnd;
    this.word = '';
  }
}

class Trie {
  root: TrieNode;
  
  constructor(){
    this.root = new TrieNode();    
  }
  
  public insert(key: string) {
    let curr = this.root;
    
    for(let c of key){
      if(!curr.children.has(c))
        curr.children.set(c, new TrieNode());
      
      curr = curr.children.get(c);
    }
    curr.isEnd = true;
    curr.word = key;
  }

  public getWord(key: string): string {
    let curr = this.root;
    
    for(let c of key){
      if(!curr.children.has(c) || curr.word)
        break;
      
      curr = curr.children.get(c);
    }
    return curr.word || key;
  }

  public search(key: string): boolean {
    let curr = this.root;
    
    for(let c of key){
      if(!curr.children.has(c))
        return false;
      
      curr = curr.children.get(c);
    }
    return curr.isEnd;
  }

  public startsWith(key: string): boolean {
    let curr = this.root;
    
    for(let c of key){
      if(!curr.children.has(c))
        return false;
      
      curr = curr.children.get(c);
    }
    return true;
  }
}

function replaceWords(dictionary: string[], sentence: string): string {
  const trie = new Trie(),
        keys = sentence.split(' ');
  let result = '';
  
  for(let d of dictionary)
    trie.insert(d);
  
  for(let key of keys)
    result = result.concat(trie.getWord(key), ' ');
  
  return result.trim();
};