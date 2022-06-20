class TrieNode {
  public next: Array<TrieNode>;
  public size: number;

  constructor() {
    this.next = new Array<TrieNode>();
    this.size = -1;
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
    
    curr.size = word.length;
  }
  
  public search(word: string): number {
    let curr = this.root;
    
    for(let c of word) {
      const i = c.charCodeAt(0) - 97;
      curr = curr.next[i];
    }

    if(curr.next.length)
      return 0;
    else
      return curr.size + 1;
  }

}

function minimumLengthEncoding(words: string[]): number {
  const trie = new Trie(),
        set = new Set<string>(words);
  let ans = 0;
  
  for(let word of words)
    trie.insert(reverse(word));
  
  for(let word of set.values())
    ans += trie.search(reverse(word));
  
  return ans;
};

function reverse(s: string): string {
  if(!s)
    return s;
  else
    return reverse(s.substring(1)).concat(s.at(0));
}