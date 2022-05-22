function maximumBags(capacity: number[], rocks: number[], additionalRocks: number): number {
// 0-1 knapsack padhna hai 
//   uski jarurat nahi hai.
//   pehle question padha kr fir judge kiya kar.
  
// https://www.youtube.com/watch?v=twiJ9IGn_us
  
  const N = capacity.length;
  let fullBagCount = 0;
  
  for(let i = 0; i < N; i++)
    capacity[i] = capacity[i] - rocks[i];
  
  capacity.sort((a, b) => a - b);
  
  for(let i = 0; i < N; i++){
    if(capacity[i] == 0)
      fullBagCount++
    else 
      if(additionalRocks >= capacity[i]){
      additionalRocks -= capacity[i];
      fullBagCount++;
    } else {
      break;
    }
  }
  return fullBagCount;

};