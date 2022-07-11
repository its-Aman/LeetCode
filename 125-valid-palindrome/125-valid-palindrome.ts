function isPalindrome(s: string): boolean {
  const S = encode(s.toLowerCase());
  let i = 0,
      j = S.length - 1;
  
  while(i <= j)
    if(S.at(i++) != S.at(j--))
      return false;

  return true;
};

function encode(s: string): string {
  let result = '';
  
  for(let c of s) {
    const cCode = c.charCodeAt(0);
   
    if(cCode >= 97 && cCode <= 122 || (cCode >= 48 && cCode <= 57))
      result += c;
  }
  // console.log(result)
  return result;
}