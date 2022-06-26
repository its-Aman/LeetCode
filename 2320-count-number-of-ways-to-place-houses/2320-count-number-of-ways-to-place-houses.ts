function countHousePlacements(N: number): BigInt {
  const MOD = 1000000007n;
  let a = 1n,
      b = 2n;
  for(let i = 1; i < N; i++)
    [a, b] = [b, (a + b) % MOD];
  
  return (b * b) % MOD;
};