function numberOfSteps(num: number): number {
  let ans = 0;
  
  while(num){
    if(num == 1){
      ans += 1;
      num--;  
    } else if(num % 2 == 1){
      ans += 2;
      num--;  
    } else {
      ans += 1;      
    }
    
    num >>= 1;
  }
  return ans;
};