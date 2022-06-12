function isMatch(s: string, p: string): boolean {
  if(!p.length)
    return s.length == 0;
  
  let first_match = s.length && [s.at(0), '.'].includes(p.at(0));
  
  if(p.length >= 2 && p.at(1) == '*')
    return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
  else
    return first_match && isMatch(s.substring(1), p.substring(1));
  
};