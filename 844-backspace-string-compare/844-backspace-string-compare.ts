function backspaceCompare(s: string, t: string): boolean {
  const s1 = new Array(0),
        s2 = new Array(0);
  
  for(let c of s)
    if(c == '#')
      s1.pop();
    else
      s1.push(c);

  for(let c of t)
    if(c == '#')
      s2.pop();
    else
      s2.push(c);

  return s1.join('') == s2.join('');
};