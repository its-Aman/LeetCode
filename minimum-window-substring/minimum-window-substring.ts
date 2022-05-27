// https://www.youtube.com/watch?v=e1HlptlipB0
// s = "ADOBECODEBANC"
// t = "ABC"
function minWindow(s: string, t: string): string {
  let tMap = {}, // map for holding original target string
      sMap = {}, // map to holding current elements in window
      ans = "", // minWindow that contain all the chars of t
      matchCount = 0, // keeping track of items in sMap
      desiredMatchCount = t.length, // number of item needed to get the window contains all the chars of t
      i = -1, // left
      j = -1; // right
  
//   creating freq map of the target string
  
  for(let c of t){
    if(c in tMap)
      tMap[c]++
    else
      tMap[c] = 1;
  }

//   looping until we've traversed all the string 
  
  while(true) {
    let flag1 = false, // flag to keep check for acquire
        flag2 = false; // flag to keep check for release
    
//     acquire
//     keep acquiring until either to the end
//     and the current matchCount is not met with desiredMatchCount
    while(i < s.length && matchCount < desiredMatchCount){
      i++; // acquiring next element 
      const c = s.charAt(i);
      
//      keeping it's freq in sMap to check further
      if(c in sMap)
        sMap[c]++
      else
        sMap[c] = 1;    
      
//       checking if we have acquired the desired element.
//       then we'll update the match count;
    if((sMap[c] || 0) <= (tMap[c] || 0))
        matchCount++;
//       tracking that we are still acquiring.
      flag1 = true;
    }
    
//     collect and release    
//     we'll start releasing if j is under boundry of i and
//     we have a desired match found in current window.
    while(j < i && matchCount == desiredMatchCount){
//       we take the possible ans that holds all the chars of t
      const possibleAns = s.substring(j + 1, i + 1);
//       we update the ans if there is smaller window of possibeAns
      if(ans.length == 0 || possibleAns.length < ans.length)
        ans = possibleAns;
//       we start releasing 
      j++;
//       we'll remove the item from sMap since we've release this char
      const c = s.charAt(j);
      if(sMap[c] == 1)
        delete sMap[c];
      else
        sMap[c]--;
      
//       we check if the item that is released is part of the ans and we've released a important char
//       if yes, we decrement the match count since required item was released.
      if((sMap[c] || 0) < (tMap[c] || 0))
        matchCount--;
      
//       tracking that we are still collecting and releasing.
      flag1 = true;
    }
    
//  if we're not either acquiring or releasing, break out from the loop.   
    if(!flag1 && !flag2)
      break;
  }

//   ans contains our smallest window that have all the chars.
  return ans;
};