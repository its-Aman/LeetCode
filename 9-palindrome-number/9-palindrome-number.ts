function isPalindrome(x: number): boolean {
  const str = x.toString();
  
  let i = 0,
      j = str.length - 1;
  while(i < j)
    if(str.at(i++) != str.at(j--))
      return false;
  return true;
};