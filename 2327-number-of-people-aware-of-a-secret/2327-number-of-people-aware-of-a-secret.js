/**
 * @param {number} n
 * @param {number} delay
 * @param {number} forget
 * @return {number}
 */
var peopleAwareOfSecret = function(N, delay, forget) {
  const MOD = 1000000007,
        shares = new Array(N + 1).fill(0),
        forgets = new Array(N + 1).fill(0);
  let shareToday = 0,
      peopleKnow = 1;
  
  if(delay < N)
    shares[delay + 1] = 1;

  if(forget < N)
    forgets[forget + 1] = 1;
  
  for(let i = delay; i <= N; i++) {
    shareToday += shares[i] % MOD;
    shareToday -= forgets[i] % MOD;
    
    peopleKnow -= forgets[i] % MOD;
    peopleKnow += shareToday % MOD;
    
    if(i + delay < N + 1)
      shares[i + delay] += shareToday % MOD;
    
    if(i + forget < N + 1)
      forgets[i + forget] += shareToday % MOD;
  }
  
  return peopleKnow % MOD;
};