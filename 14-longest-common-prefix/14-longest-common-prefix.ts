function longestCommonPrefix(strs: string[]): string {
  let ans = "";
  
  strs.sort((a, b) => a.length - b.length);
  
  const smallestWord = strs[0];
  
  for(let i = 0; i < smallestWord.length; i++) {
    let isOk = true;
    for(let str of strs) {
      if(str.at(i) !== smallestWord.at(i)) {
        isOk = false; 
        break;
      }
    }
    
    if(!isOk)
      return ans;
    else
      ans += smallestWord.at(i);
  }
    
  return ans;
};