function titleToNumber(columnTitle: string): number {
  let N = columnTitle.length,
      num = 0;
  
  for(let i = N - 1; i >= 0; i--)
    num += (columnTitle.charCodeAt(i) - 64 /* % 65 - 1*/) * Math.pow(26, N - i - 1);
  
  return num;
};