// https://www.youtube.com/watch?v=H9bfqozjoqs

function coinChange(coins: number[], amount: number): number {
  
  const N = coins.length,
        map = new Array(amount + 1).fill(amount + 1);
  
  map[0] = 0;
  
  for(let i = 1; i <= amount; i++)
    for(let coin of coins)
      if(coin <= i){
        // console.log({i, coin, m_i: map[i], m_i_c: map[i-coin]})
        map[i] = Math.min(map[i], 1 + map[i - coin]);        
      }

  // console.log(map);
  return map[amount] > amount ? -1 : map[amount]; 
}