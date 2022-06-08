function removePalindromeSub(s: string): number {
  if(isPalindrome(0, s.length - 1))
    return 1;
  else
    return 2;
  
  function isPalindrome(i: number, j: number): boolean {
    while(i <= j)
      if(s.charAt(i++) != s.charAt(j--))
        return false;
    return true;
  }
};

