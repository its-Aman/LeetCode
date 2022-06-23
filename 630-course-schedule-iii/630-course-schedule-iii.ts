function scheduleCourse(courses: number[][]): number {
  const N = courses.length;
  courses.sort((a, b) => a[1] - b[1]);
  let time = 0,
      count = 0;
  
  for(let i = 0; i < N; i++) {
    if(time + courses[i][0] <= courses[i][1]) {
      time += courses[i][0];
      // count++;
      courses[count++] = courses[i];
    } else {
      let max_i = i;
      for(let j = 0; j < count; j++)
        if(courses[max_i][0] < courses[j][0])
          max_i = j;
      
      if(courses[i][0] < courses[max_i][0]) {
        time += courses[i][0] - courses[max_i][0];
        courses[max_i] = courses[i];
      }
      
      // courses[max_i][0] = -1;
    }
  }
  
  return count;
}

function scheduleCourse_recursive_TLE(courses: number[][]): number {
  const N = courses.length;
  courses.sort((a, b) => a[1] - b[1]);
  const memo = Array.from(new Array(N), () => new Array(1 + courses[N - 1][1]));

  return schedule(0, 0);
  
  function schedule(i: number, time: number) : number {
    if(i == N)
      return 0;
    
    if(memo[i][time])
      return memo[i][time];
    
    let taken = 0;
    
    if(time + courses[i][0] <= courses[i][1])
      taken = 1 + schedule(i + 1, time + courses[i][0]);
    
    let not_taken = schedule(i + 1, time);
    
    memo[i][time] = Math.max(taken, not_taken);
    
    return memo[i][time];
  }
  
//   let currentTotalTime = 0,
//       ans = 0;
  
//   console.log({courses})

//   for(let [i, [duration, lastDay]] of courses.entries()) {
//     console.log({i, duration, lastDay, currentTotalTime, ans})
//     currentTotalTime += duration;

//     if(currentTotalTime <= lastDay) {
//       ans++;
//     } else {
//       currentTotalTime -= duration;
//     }
//   }
  
//     return ans;
  };