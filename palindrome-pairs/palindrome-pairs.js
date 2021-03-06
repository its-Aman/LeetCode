/*

Trie typescript solution isn't working due to memory constrains. IDK why. 

Wasted my 2 days over it. LC is bad in these things. 

class TrieNode {
  public next: Map<string, TrieNode>;
  public index: number;
  public list: Array<number>;
  
  constructor() {
    this.next = new Map<string, TrieNode>();
    this.index = -1;
    this.list = new Array(0);
  }
}

function palindromePairs(words: string[]): number[][] {
  const N = words.length,
        ans = new Array(),
        root = new TrieNode();
  let curr = root;
  
  for(let i = 0; i < N; i++) 
    addWord(curr, words[i], i);
  
  curr = root;
  
  for(let i = 0; i < N; i++) 
    search(words, i, curr, ans);
  
  return ans;
};

function addWord(root: TrieNode, word: string, index: number): void {
  for(let i = word.length - 1; i >= 0; i--) {
    const j = word.charAt(i);

    if(!root.next.has(j))
      root.next.set(j, new TrieNode());
    
    if(isPalindrome(word, 0, i))
      root.list.push(index);
    
    root = root.next.get(j);
  }
  
  root.list.push(index);
  root.index = index;
}

function search(words: string[], i: number, root: TrieNode, ans: number[][]): void {
  const word = words[i];

  for(let j = 0; j < word.length; j++){
    if(~root.index && root.index != i && isPalindrome(word, j, word.length - 1))
      ans.push([i, root.index]);
    
    root = root.next.get(word.charAt(j));
    
    if(!root)
      return;
  }
  
  for(let j of root.list)
    if(i != j)
      ans.push([i, j]);
}

function isPalindrome(word: string, i: number, j: number): boolean{
  while(i < j)
    if(word.charAt(i++) != word.charAt(j--))
      return false;
  return true;
}


*/

// https://leetcode.com/problems/palindrome-pairs/discuss/1918670/Simple-JS-Solution-w-Comments-Map-and-Trie

/**
 * *Time: O(N x M^2)
 * *Space: O((N + K)^2)
 */

const palindromePairs = (words) => {
  const root = {};
  const output = [];

  const isPalindrome = (word) => {
    let L = 0;
    let R = word.length - 1;

    while (L < R) {
      if (word[L++] !== word[R--]) return false;
    }

    return true;
  };

  const insertReversed = (words) => {
    for (let i = 0; i < words.length; i++) {
      const word = words[i];
      let node = root;

      for (let j = word.length - 1; j >= 0; j--) {
        const char = word[j];

        if (!node[char]) node[char] = {};

        node = node[char];
      }

      node.isEnd = true;
      node.index = i;
    }
  };

  // empty string forms palindrome w/ every palindrome in the list
  const handleEmptyString = (root) => {
    if (!root.isEnd) return; // if isEnd, empty string

    for (let i = 0; i < words.length; i++) {
      const valid = isPalindrome(words[i]);

      if (root.index === i) continue;
      if (valid) output.push([i, root.index]);
    }
  };

  // traverse trie along given word and return last prefix node

  // case 2: if word shorter - get last prefix node given the word and DFS to check if trie has palindromes
  // case 3: if word longer - check if suffix is valid palindrome, if not stop
  const getLastPrefixNode = (word, idx) => {
    let node = root;

    for (let i = 0; i < word.length; i++) {
      const char = word[i];

      // case 3: word is longer
      // check if rest of the word form valid palindrome
      if (!node[char]) return;
      if (node[char].isEnd && node[char].index !== idx && i < word.length - 1) {
        const suffix = word.slice(i + 1);
        const valid = isPalindrome(suffix);

        if (valid) output.push([idx, node[char].index]);
      }

      node = node[char];
    }

    return node;
  };

  // traverse trie starting from lastPrefixNode find valid palindromes
  const traverse = (node, idx, suffix) => {
    // case 1. same word length
    if (node.isEnd && node.index !== idx) {
      const valid = isPalindrome(suffix);

      if (valid) output.push([idx, node.index]);
    }

    // case 2. word is shorter
    // traverse trie until valid match found
    for (const key in node) {
      traverse(node[key], idx, suffix + key);
    }
  };

  insertReversed(words);
  handleEmptyString(root);

  for (let i = 0; i < words.length; i++) {
    const lastPrefixNode = getLastPrefixNode(words[i], i);

    if (lastPrefixNode) traverse(lastPrefixNode, i, '');
  }

  return output;
};