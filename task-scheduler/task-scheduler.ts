function leastInterval(tasks: string[], n: number): number {
  let counter: number[] = new Array(26).fill(0),
      maxTaskCount: number = 0,
      tasksWithMostFreq: number = 0,
      N = tasks.length;
  
  for(let i = 0; i < N; i++){
    let index = tasks[i].charCodeAt(0) % 'A'.charCodeAt(0);
    counter[index]++;
    
    if(maxTaskCount == counter[index])
      tasksWithMostFreq++;
    
    if(counter[index] > maxTaskCount){
      maxTaskCount = counter[index];
      tasksWithMostFreq = 1;
    }
  }
  
  // partCount = count(A) - 1
  // emptySlots = partCount * (n - (count of tasks with most frequency - 1))
  // availableTasks = tasks.length - count(A) * count of tasks with most frenquency
  // idles = max(0, emptySlots - availableTasks)
  // result = tasks.length + idles
  
  const partCount = maxTaskCount - 1,
        partLength = n - (tasksWithMostFreq - 1),
        emptySlots = partCount * partLength,
        availableTasks = N - (maxTaskCount * tasksWithMostFreq),
        idles = Math.max(0, emptySlots - availableTasks),
        result = N + idles;
    
  return result;
};