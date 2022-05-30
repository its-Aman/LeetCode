function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
  const N = wordList.length,
        wordSet = new Set(wordList);
        
  let steps = 1,
      q = [beginWord];
  
  while(q.length){
    const next = [];
    
    for(let word of q){
      
      if(word == endWord)
        return steps;
      
      for(let i = 0; i < word.length; i++) {
        
        for(let j = 97; j < 26 + 97; j++) {
          if(word.charCodeAt(i) == j)
            continue;
          
          const newWord = word.slice(0, i) + String.fromCharCode(j) + word.slice(i + 1);
          
          if(wordSet.has(newWord)){
            next.push(newWord);
            wordSet.delete(newWord);
          }
        }
      }
    }
    
    q = next;
    steps++;
  }
  
  return 0;
};