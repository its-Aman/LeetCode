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