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

  public insert(word: string): void {
    let curr = this.root;
    for(let c of word){
      if(!curr.children[c.charCodeAt(0) - 97])
        curr.children[c.charCodeAt(0) - 97] = new TrieNode();
      curr = curr.children[c.charCodeAt(0) - 97];
    }
    curr.isWord = true;
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
    trie.insert(word);
  
  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
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
  
    if(temp == '#')
      return;
  
    node = node.children[temp.charCodeAt(0) - 97];

    if(!node)
      return;

    board[i][j] = '#';

    for(let [x, y] of nbrs)
      backtrack(currWord.concat(temp), node, x + i, y + j);
  
    board[i][j] = temp;
  }
};