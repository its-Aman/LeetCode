function maximumUnits(boxTypes: number[][], truckSize: number): number {
  const N = boxTypes.length;
  
  boxTypes.sort((a, b) => -a[1] + b[1]);
  
  let ans = 0;

  // console.log({boxTypes})
  
  for(let i = 0; i < N; i++) {
    if(truckSize <= 0)
      return ans;
    
    const [numberOfBoxes, numberOfUnitPerBox] = boxTypes[i];
    ans += Math.min(truckSize, numberOfBoxes) * numberOfUnitPerBox;
    truckSize -= numberOfBoxes;
  }
  
  return ans;
};