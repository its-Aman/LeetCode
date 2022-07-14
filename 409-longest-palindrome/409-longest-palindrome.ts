function longestPalindrome(s: string): number {
  const dict = new Array<number>(26 * 2).fill(0);
  let len = 0,
      isOnePresent = false;
  
  for(let i = 0; i < s.length; i++) {
    const code = s.charCodeAt(i);
    
    if(code < 97) {
      // capital letters
      dict[code - 65] += 1;
    } else {
      // small letters
      dict[26 + (code - 97)] += 1;
    }
  }
  
  for(let i = 0; i < dict.length; i++) {
    if(dict[i] % 2 == 0)
      len += dict[i];
    
    if(dict[i] % 2 == 1) {
      len += dict[i] - 1;
      isOnePresent = true;
    }

  }
  
  if(isOnePresent)
    len += 1;

  return len;
};