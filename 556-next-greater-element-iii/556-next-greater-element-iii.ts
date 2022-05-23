// https://leetcode.com/problems/next-greater-element-iii/discuss/983076/Python-O(m)-solution-explained

function nextGreaterElement(n: number): number {
//   lets take the example 
//   n = 234157641
  const nStr = n.toString().split(''),
        N = nStr.length;
  
  let i = N - 1;
  
//   Finding the next smaller number starting from right going to left.
  while(i > 0 && nStr[i] <= nStr[i - 1])
    i--
//   234157641
//   <----i-->

//   If we have found no smaller number from previous one, that means the number is itself arranged 
//   in a way that it is the smallest. 
  if(i == 0)
    return -1;
  
  let j = i;
  
//   lets start finding the next bigger number to the right, because i - 1 is the number 
//   which is smaller to i
  while(j + 1 < N && nStr[j + 1] > nStr[i - 1])
    j++;

//   234157641
//   <----ij->

//   Now i points to the current smaller number next to i + 1 and
//   j represent the number greater then the i - 1 to the right
  [nStr[i - 1], nStr[j]] = [nStr[j], nStr[i - 1]];

//   234167541
//   <----ij->

// Now we reverse the number starting from i.

//   234167541
//   <----ij->

  nStr.splice(i, N - i, ...nStr.slice(i).reverse());

//   234161457
//   <----ij->
// converting string array to number.
  let res = +nStr.join('');
  
//   base condition for keeping the number within range.
  if(res >= (-1 * (1 << 31)))
    return -1;
  else
    return res;
  
};