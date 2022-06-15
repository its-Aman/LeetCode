function longestStrChain(words: string[]): number {
  // return longestStrChain_MINE(words);
  return longestStrChain_SOL(words);
}

function longestStrChain_SOL(words: string[]): number {
  const map = new Map<string, number>();
  
  words.sort((a, b) => a.length - b.length);

  let max = 0;
  
  for(let word of words) {
    let currMax = 0;
    for(let i = 0; i < word.length; i++) {
      const replacedWord = word.substring(0, i).concat(word.substring(i + 1));
      currMax = Math.max(currMax, (map.get(replacedWord) || 0) + 1);
    }
    
    map.set(word, currMax);
    max = Math.max(currMax, max);
  }
  return max;
}

function longestStrChain_MINE(words: string[]): number {

  // overall complexity = O(nlogn) + O(n) + O(n) x O(max(word[i].length))
// ~= O(n x max(word[i].length))

  const N = words.length,
        map = new Map<string, number>(),
        dp = new Array<number>(N + 1).fill(1);

  dp[0] = 0;
  words.sort((a, b) => a.length - b.length); // O(nlogn)
  // console.log({words})

  for(let i = 0; i < N; i++) // O(n)
    map.set(words[i], i);
  
  for(let i = 0; i < N; i++) { // O(n)
    const word = words[i];
    // console.log({word, i});
    
    for(let j = 0; j < word.length; j++){ //O(max(word[i].length))
      const replacedWord = word.substring(0, j).concat(word.substring(j + 1));
      // console.log({replacedWord, j});
      
      if(!replacedWord.length)
        continue;
      
      if(words.includes(replacedWord))
        dp[i + 1] = Math.max(dp[i + 1], 1 + dp[1 + map.get(replacedWord)]);
      
      // console.log(dp)
    }
  }
  
  return Math.max(...dp);
};