function makesquare(matchsticks: number[]): boolean {
  const N = matchsticks.length,
        sides = [0,0,0,0];
  
  const parimeter = matchsticks.reduce((acc, curr) => acc + curr, 0),
        possibleSquareSide = parimeter / 4;
  
  if(parimeter % 4 != 0)
    return false;
  
  matchsticks.sort((a, b) => -a + b);
  
  return findSquare(0);
  
  function findSquare(idx: number): boolean {
    // console.log({sides, idx})
    if(idx == N) {
      return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3] && sides[3] == sides[0];
    }
      
    for(let s = 0; s < 4; s++) {
        
      if(sides[s] + matchsticks[idx] <= possibleSquareSide){
      
        sides[s] += matchsticks[idx];

        if(findSquare(idx + 1))
          return true;

        sides[s] -= matchsticks[idx];
      }
    }

    return false;
  }
};