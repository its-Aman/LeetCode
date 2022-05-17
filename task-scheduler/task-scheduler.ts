// https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation

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
  
  const partCount = maxTaskCount - 1,
        partLength = n - (tasksWithMostFreq - 1),
        emptySlots = partCount * partLength,
        availableTasks = N - (maxTaskCount * tasksWithMostFreq),
        idles = Math.max(0, emptySlots - availableTasks),
        result = N + idles;
    
  return result;
};