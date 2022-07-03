function wiggleMaxLength(nums: number[]): number {
  const N = nums.length;
  
  if(N < 2)
    return N;
  
  let prevDiff = nums[1] - nums[0],
      count = prevDiff == 0 ? 1 : 2;
  
  for(let i = 2; i < N; i++) {
    const diff = nums[i] - nums[i - 1];
    
    if((prevDiff >= 0 && diff < 0) || (prevDiff <= 0 && diff > 0)) {
      count += 1;
      prevDiff = diff;
    }
  }
  
  return count;
}

function wiggleMaxLength_N_1_DP(nums: number[]): number {
  const N = nums.length,
        dp = new Array(N).fill(1);
  let upDP = 1,
      downDP = 1; 
  
  for(let i = 1; i < N; i++) {
    if(nums[i] > nums[i - 1]) {
      upDP = 1 + downDP;
    } else if(nums[i] < nums[i - 1]) {
      downDP = 1 + upDP;
    }
  }

  return Math.max(upDP, downDP);
}

function wiggleMaxLength_N(nums: number[]): number {
  const N = nums.length,
        dp = new Array(N).fill(1),
        upDP = new Array(N).fill(1),
        downDP = new Array(N).fill(1); 
  
  for(let i = 1; i < N; i++) {
    if(nums[i] > nums[i - 1]) {
      upDP[i] = 1 + downDP[i - 1];
      downDP[i] = downDP[i - 1];
    } else if(nums[i] < nums[i - 1]) {
      downDP[i] = 1 + upDP[i - 1];
      upDP[i] = upDP[i - 1];
    } else {
      upDP[i] = upDP[i - 1];
      downDP[i] = downDP[i - 1];
    }
  }

  return Math.max(upDP[N - 1], downDP[N - 1]);
}

function wiggleMaxLength_N2(nums: number[]): number {
  const N = nums.length,
        dp = new Array(N).fill(1),
        upDP = new Array(N).fill(0),
        downDP = new Array(N).fill(0); 
  
  for(let i = 1; i < N; i++) {
    for(let j = 0; j < i; j++) {
      if(nums[i] > nums[j])
        upDP[i] = Math.max(upDP[i], 1 + downDP[j]);
      else
        downDP[i] = Math.max(downDP[i], 1 + upDP[j])
    }
  }

  return 1 + Math.max(upDP[N - 1], downDP[N - 1]);
};
