function maximumBags(capacity: number[], rocks: number[], additionalRocks: number): number {
// 0-1 knapsack padhna hai 
//   uski jarurat nahi hai.
//   pehle question padha kr fir judge kiya kar.
  
// https://www.youtube.com/watch?v=twiJ9IGn_us
  
  const N = capacity.length,
        vacancy = new Array(N).fill(0);
  let fullBagCount = 0;
  
  for(let i = 0; i < N; i++)
    vacancy[i] = capacity[i] - rocks[i];
  
  vacancy.sort((a, b) => a - b);
  
  for(let i = 0; i < N; i++){
    if(vacancy[i] == 0)
      fullBagCount++
    else 
      if(additionalRocks >= vacancy[i]){
      additionalRocks -= vacancy[i];
      vacancy[i] = 0;
      fullBagCount++;
    } else {
      break;
    }
  }
  return fullBagCount;

};