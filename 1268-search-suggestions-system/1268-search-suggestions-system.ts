class TrieNode {
  public next: Array<TrieNode>;
  public isEnd: boolean;

  constructor() {
    this.next = new Array<TrieNode>();
    this.isEnd = false;
  }
}

class Trie {
  public root: TrieNode;

  constructor() {
    this.root = new TrieNode();
  }

  public insert(word: string): void {
    let curr = this.root;
    
    for(let c of word) {
      const i = c.charCodeAt(0) - 97;
      if(!curr.next[i])
        curr.next[i] = new TrieNode();
      curr = curr.next[i];
    }
    curr.isEnd = true;
  }

  public search(prefix: string): string[] {
    let curr = this.root,
        words = new Array<string>();

    for(let c of prefix) {
      const i = c.charCodeAt(0) - 97;
      if(!curr.next[i])
        return words;

      curr = curr.next[i];
    }
    
    this.dfs(curr, prefix, words);
    return words;
  }

  public dfs(curr: TrieNode, prefix: string, words: Array<string>): void {
    if(words.length == 3)
      return;
    
    if(curr.isEnd)
      words.push(prefix);
  
    for(let i = 0; i < 26; i++)
      if(curr.next[i])
        this.dfs(curr.next[i], prefix.concat(String.fromCharCode(97 + i)), words)
  }

}

function suggestedProducts(products: string[], searchWord: string): Array<Array<string>> {
  const trie = new Trie(),
        ans = new Array<Array<string>>();
  let prefix = '';
  
  for(let product of products)
    trie.insert(product);
  
  for(let c of searchWord) {
    prefix = prefix.concat(c);
    ans.push(trie.search(prefix));
  }
  
  return ans;
};