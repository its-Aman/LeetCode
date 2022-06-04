// { Driver Code Starts
//Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => {
  inputString += inputStdin;
});

process.stdin.on("end", (_) => {
  inputString = inputString
    .trim()
    .split("\n")
    .map((string) => {
      return string.trim();
    });

  main();
});

function readLine() {
  return inputString[currentLine++];
}

/* Function to print an array */
function printArray(arr, size) {
  let i;
  let s = "";
  for (i = 0; i < size; i++) {
    if(arr[i] === -0)
      arr[i] = 0;
    s += arr[i] + " ";
  }
  console.log(s);
}

function main() {
  let t = parseInt(readLine());
  for (let i = 0; i < t; i++) {
    let n = parseInt(readLine());
    let arr = new Array(n);
    let input_line = readLine().split(" ").map((x) => parseInt(x));
    for(let j = 0;j<n;j++) {
        arr[j] = input_line[j];
    }
    let obj = new Solution();
    obj.quickSort(arr,0,n-1);
    printArray(arr,arr.length);
  }
}// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} low
 * @param {number} high
 */
 
class Solution
{
    partition(arr, lo, hi){
        // Your code here
        const pivot = arr[hi];
        let i = lo - 1;
        
        for(let j = lo; j <= hi; j++){
            if(arr[j] < pivot){
                i++;
                this.swap(arr, i, j);
            }
        }
        this.swap(arr, i + 1, hi);
        return i + 1;
    }
    
    quickSort(arr, lo, hi){
        //code here
        if(lo < hi){
            let pi = this.partition(arr, lo, hi);
            
            this.quickSort(arr, lo, pi - 1);
            this.quickSort(arr, pi + 1, hi);
        }
    }
    
    swap(arr, i, j){
        [arr[i], arr[j]] = [arr[j], arr[i]];
    }
}