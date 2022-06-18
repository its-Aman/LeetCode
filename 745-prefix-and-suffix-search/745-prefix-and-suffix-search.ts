/*
["WordFilter","f","f","f","f","f","f","f","f","f","f"]
[
  [["cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"]],
  ["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]
]

*/
class TrieNode {
  public child: Array<TrieNode>;
  public index: number;

  constructor(index = -1) {
    this.child = new Array();
    this.index = index;
  }
}

class WordFilter {
    root: TrieNode;

    constructor(words: string[]) {
      this.root = new TrieNode();
      
      for(let [i, word] of words.entries())
        for(let j = 0; j < word.length; j++)
          this.insert(word.concat('{', word).substring(j), i);
    }

    f(prefix: string, suffix: string): number {
      const index = this.search(suffix.concat('{', prefix));
      return index;
    }

    private insert(word: string, index: number): void {
      let curr = this.root;
      
      for(let c of word) {
        const i = c.charCodeAt(0) - 97;
        if(!curr.child[i])
          curr.child[i] = new TrieNode(index);
        curr = curr.child[i];
        curr.index = index;
      }
      // curr.index = index;
    }
    
    private search(prefix: string): number {
      let curr = this.root;
      
      for(let c of prefix) {
        const i = c.charCodeAt(0) - 97;
        if(!curr.child[i])
          return -1;
        curr = curr.child[i];
      }
      return curr.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */