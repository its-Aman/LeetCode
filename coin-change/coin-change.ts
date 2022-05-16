// https://www.youtube.com/watch?v=H9bfqozjoqs

function coinChange(coins: number[], amount: number): number {
  
  const N = coins.length,
      map = new Array(amount + 1).fill(amount + 1);
  
  map[0] = 0;
  
  for(let i = 1; i <= amount; i++)
    for(let coin of coins)
      if(coin <= i)
        map[i] = Math.min(map[i], 1 + map[i - coin]);

  return map[amount] > amount ? -1 : map[amount]; 
}