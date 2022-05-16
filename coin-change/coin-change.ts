// https://www.youtube.com/watch?v=H9bfqozjoqs

function coinChange(coins: number[], amount: number): number {
  coins.sort((a, b) => a - b);
  
  const N = coins.length,
      map = new Array(amount + 1).fill(amount + 1);
  
  map[0] = 0;
  
  for(let i = 1; i <= amount; i++){
    for(let coin of coins){
      if(coin <= i)
        map[i] = Math.min(map[i], 1 + map[i - coin]);
      else 
        break;
    }
  }

  return map[amount] > amount ? -1 : map[amount]; 
}