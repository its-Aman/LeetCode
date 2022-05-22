function minimumLines(stockPrices: number[][]): number {
    const N = stockPrices.length;
    let ans = 0;
  
    if(N == 1)
      return ans;

    stockPrices.sort((a,b)=>a[0] - b[0])

    let dy1 = BigInt(stockPrices[0][1] - stockPrices[1][1]), 
        dx1 = BigInt(stockPrices[0][0] - stockPrices[1][0]);

    for (let i = 1; i < N - 1; i++) {
        let dy2 = BigInt(stockPrices[i][1] - stockPrices[i + 1][1]),
            dx2 = BigInt(stockPrices[i][0] - stockPrices[i + 1][0]),
            m1 = dy1 * dx2,
            m2 = dy2 * dx1;
      
        if(m1 == m2)
          continue;
      
          ans++;
          dy1 = dy2;
          dx1 = dx2;
            
    }
    return ans + 1;
}
