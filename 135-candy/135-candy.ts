function candy(ratings: number[]): number {
  const N = ratings.length;
  
  let peak = 0,
      up = 0,
      down = 0,
      ans = 1;
  
  for(let i = 1; i < N; i++) {
    if(ratings[i] > ratings[i - 1]) {
      peak = ++up;
      down = 0;
      ans += 1 + up;
    } else if(ratings[i] == ratings[i - 1]) {
      peak = up = down = 0;
      ans += 1;
    } else {
      up = 0;
      down++;
      ans += down + (down > peak ? 1 : 0);
    }
  }
  
  return ans;
}

function candy2(ratings: number[]): number {
  const N = ratings.length,
        candies = new Array(N).fill(1);
  
  if(N <= 1)
    return N;
  
  for(let i = 1; i < N; i++) {
    if(ratings[i] > ratings[i - 1])
      candies[i] = 1 + candies[i - 1];
  }

  let ans = candies[N - 1];
  
  for(let i = N - 1; i > 0; i--) {
    if(ratings[i - 1] > ratings[i])
      candies[i - 1] = Math.max(1 + candies[i], candies[i - 1]);
   ans += candies[i - 1];
  }
  
  return ans;
};