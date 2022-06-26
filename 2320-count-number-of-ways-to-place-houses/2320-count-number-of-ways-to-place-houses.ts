function countHousePlacements(N: number): BigInt {
  const MOD = 1000000007n;
  let house = 1n,
      plot = 1n,
      total = house + plot;
  
  for(let i = 2; i <= N; i++) {
    house = plot;
    plot = total;
    total = (house + plot) % MOD;
  }
  
  return (total * total) % MOD;
};