class TrieNode {
  public children: Array<TrieNode>;
  isWord: boolean;

  constructor(isWord = false) {
    this.children = new Array<TrieNode>(26);
    this.isWord = isWord;
  }
}

class Trie {
  public root: TrieNode;
  
  constructor() {
    this.root = new TrieNode();
  }

  public add(word: string): void {
    let curr = this.root;
    for(let c of word){
      if(!curr.children[97 - c.charCodeAt(0)])
        curr.children[97 - c.charCodeAt(0)] = new TrieNode();
      curr = curr.children[97 - c.charCodeAt(0)];
    }

    curr.isWord = true;
  }
  
  public search(word: string): boolean {
    let curr = this.root;
    for(let c of word){
      if(!curr.children[97 - c.charCodeAt(0)])
        return false;
      curr = curr.children[97 - c.charCodeAt(0)];
    }

    return curr.isWord;
  }

  public startsWith(word: string): boolean {
    let curr = this.root;
    for(let c of word){
      if(!curr.children[97 - c.charCodeAt(0)])
        return false;
      curr = curr.children[97 - c.charCodeAt(0)];
    }

    return true;
  }

}

function findWords(board: string[][], words: string[]): string[] {
  const M = board.length,
        N = board[0].length,
        trie = new Trie(),
        node = trie.root,
        ans = new Array<string>(),
        nbrs = [[0, 1], [0, -1], [1, 0], [-1, 0]];

  for(let word of words)
    trie.add(word);
  
  for(let [i, row] of board.entries())
    for(let [j, col] of row.entries())
      backtrack('', node, i, j);

  return ans;
  
  function backtrack(currWord: string, node: TrieNode, i: number, j: number): void {

    if(node.isWord){
      ans.push(currWord);
      node.isWord = false;
    }

    if(i < 0 || i >= M || j < 0 || j >= N)
      return;

    const temp = board[i][j];

    node = node.children[97 - temp.charCodeAt(0)];

    if(!node)
      return;

    board[i][j] = '#';
    for(let [x, y] of nbrs){
      const dx = x + i,
            dy = y + j;
      backtrack(currWord.concat(temp), node, dx, dy);
    }
    board[i][j] = temp;
  }
};