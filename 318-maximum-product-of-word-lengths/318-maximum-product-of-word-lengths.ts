function maxProduct(words: string[]): number {
  const N = words.length;
  let max = 0;
  
  for(let i = 0; i < N; i++)
    for(let j = i + 1; j < N; j++)
      if(!checkForCommonChar(words[i], words[j]))
        max = Math.max(max, words[i].length * words[j].length);
  
  return max;
};
  
  
function checkForCommonChar(s1: string, s2: string): boolean {
  for(let c of s1){
    if(s2.includes(c))
      return true;
  }
  return false;
}