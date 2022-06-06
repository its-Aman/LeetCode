class TrieNode<T> {
  public children: Map<T, TrieNode<T>>;
  public isEnd: boolean;

  constructor() {
    this.children = new Map<T, TrieNode<T>>();
    this.isEnd = false;
  }
}

class Trie {
  private root: TrieNode<string>;

  constructor() {
    this.root = new TrieNode<string>();
  }

  insert(word: string): void {
    let curr = this.root;
    for (let c of word) {
      if (!curr.children.has(c)) {
        curr.children.set(c, new TrieNode<string>());
      }
      curr = curr.children.get(c);
    }
    curr.isEnd = true;
  }

  search(word: string): boolean {
    let curr = this.root;
    for (let c of word) {
      if (!curr.children.has(c)) 
        return false;

      curr = curr.children.get(c);
    }
    return curr.isEnd;
  }

  startsWith(prefix: string): boolean {
    let curr = this.root;
    for (let c of prefix) {
      if (!curr.children.has(c))
        return false;

      curr = curr.children.get(c);
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */