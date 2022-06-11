// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array

/* 
 This question is the equivalent of asking: What's the length of the longest subarray that adds up to the total sum
 of all elements in the array, minus x? Let's say this subarray adds up to the variable target.

 Once we've got the answer to that question in a variable res, we can answer the original question by 
 subtracting the resulting length from the total length of the array, since that's the number of 
 operations we'd need to perform to produce the subarray, or nums.length - res.
*/
function minOperations(nums: number[], x: number): number {
  const total = nums.reduce((acc, curr) => acc + curr),
        target = total - x,
        N = nums.length,
        map = new Map<number, number>();
  
/* If your totalSum = x, the longest subarray that adds up to x is the entire array. */
  if(target == 0)
    return nums.length

/* 
    The following map stores a map from a prefix sum to the index where it occurs. It answers the
    question: How many elements in a row from the left side do I need to grab to get a sum adding up to k? If I call
    map.get(k), I will get the answer.
*/ 
  
  let prefixSum = 0,
      res = Number.MIN_SAFE_INTEGER; // This will store the length of the longest subarray
  map.set(prefixSum, -1); // We set this to -1 because it is a special case, and I will address it later.
  
/* 
  Now, we're going to step through the array from left to right, using an index i, and adding to a sum.
  We're trying to find the longest subarray that adds up to our target value.

  On each step i, the current sum is the equivalent of considering a range of elements where
  all elements to the right of i have been excluded from our current subarray. To think back to our 
  original problem, it's like performing nums.length - i operations on the right side.
*/

  for(let i = 0; i < N; i++) {
    prefixSum += nums[i];

/*
  At this point, we've excluded nums.length - i from the right side, and the sum of all 
  elements to the left of and including i is stored in the sum variable. I'd like to know
  if I can exclude some number of elements from the left side of my current subarray
  so that my subarray sum is equal to target. Since we store prefix sums in the map,
  I'd like to know if there's a nice prefix I can use that will help me accomplish this.

  Mathematically, nice_prefix + target = sum, so I want to check if the map contains
  nice_prefix = target - sum .

*/
    
    if(map.has(prefixSum - target))
/* 
    So, I've found the nice prefix I need from the prefix map. Let's say that the nice prefix
    mapped to an index a. Now, I have a subarray in the middle of the array that adds up to target,
    where the first a elements and the last nums.length - i elements are excluded.
    What's the length of my current subarray? It's i - a.

    I need to check if this resulting length i - a is better than what I've previously found.

    What happens if sum = target? In that case, we don't need to exclude any elements
    from the left side. What's the length of my subarray in this case? It's i + 1, since our
    arrays are zero-indexed. Thus, in my map, I need to store - 1 so that the subtraction i - a
    evaluates to i + 1. This is why we made a map.put(0, -1) call earlier.

*/
      res = Math.max(res, i - map.get(prefixSum - target));
    
/* 
    It looks like we couldn't find the prefix we needed, so let's store the current sum
    (which is a prefix of elements up to index i) in the map. Since all numbers in the array
    are positive, the sum will always increase with every step of the loop, so we don't 
    have to worry about uniqueness.
*/
    map.set(prefixSum, i);
  }
  
/* 
    Now, we've found the length of the longest subarray that adds up to target, and stored in res.
    We need to answer our original question, which was the number of operations applied to both
    sides to reach x. To get this value, we return nums.length - res.

    If we didn't find a subarray that added up to target, our result value should still be its
    initial value, Integer.MIN_VALUE. In that case, no number of operations on either side
    will allow us to reduce x to 0.
*/  
  
  if(res == Number.MIN_SAFE_INTEGER)
    return -1;
  else
    return nums.length - res;
}

function minOperations_prefix_and_postfix(nums: number[], x: number): number {
  let N = nums.length,
        prefix = [nums[0]],
        postfix = [nums[nums.length - 1]];
  
  for(let i = 1; i < N; i++){
    prefix.push(prefix[i - 1] + nums[i]);
    postfix.push(postfix[i - 1] + nums[N - i - 1]);
  }
  
  let [prHi, poHi] = [binarySearch(prefix, x, 0, N - 1), binarySearch(postfix, x, 0, N - 1)];

  // console.log({prefix, postfix, prHi, poHi})
  
  if(prHi > poHi){
    [prHi, poHi] = [poHi, prHi];
    [prefix, postfix] = [postfix, prefix];
  }
  
  if(prefix[prHi] == x)
    return prHi + 1;
  else if(postfix[poHi] == x)
    return poHi + 1;
  else if(prefix[prHi] + postfix[poHi] == x)
    return prHi + 1 + poHi + 1;
  else
    return -1
};

function binarySearch(arr: number[], num: number, lo: number, hi: number): number {
  // console.log({arr, num, lo, hi})
  if(lo > hi)
    return hi;
  
  const mid = lo + ((hi - lo) >>> 1);
  if(arr[mid] == num){
    return mid;
  } else if(arr[mid] < num){
    return binarySearch(arr, num, mid + 1, hi);
  } else {
    return binarySearch(arr, num, lo, mid - 1);
  }
}