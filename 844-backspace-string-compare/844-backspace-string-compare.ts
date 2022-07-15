function backspaceCompare(S: string, T: string): boolean {
  let i = S.length - 1,
      j = T.length - 1,
      skipS = 0,
      skipT = 0;
  
  while(i >= 0 || j >= 0) {
    
    while(i >= 0) {
      if(S.at(i) == '#') {
        skipS += 1;
        i -= 1;
      } else if(skipS > 0) {
        skipS -= 1;
        i -= 1;
      } else {
        break;
      }
    }
    
    while(j >= 0) {
      if(T.at(j) == '#') {
        skipT += 1;
        j -= 1;
      } else if(skipT > 0) {
        skipT -= 1;
        j -= 1;
      } else {
        break;
      }
    }
    
    if(i >= 0 && j >= 0 && S.at(i) != T.at(j))
      return false;
    
    if((i >= 0) != (j >= 0))
      return false;
    
    i -= 1;
    j -= 1;
  }
  
  return true;
}