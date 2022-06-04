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
    obj.mergeSort(arr,0,n-1);
    printArray(arr,arr.length);
  }
}// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} l
 * @param {number} r
 */

class Solution
{
    merge(arr, l, m, r) {
        const n1 = m - l + 1,
              n2 = r - m,
              L = arr.slice(l, m + 1),
              R = arr.slice(m + 1, r + 1);
     
        let i = 0,
            j = 0,
            k = l;
     
        while (i < n1 && j < n2)
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
     
        while (i < n1) 
            arr[k++] = L[i++];
     
        while (j < n2) 
            arr[k++] = R[j++];
    }
    
    mergeSort(arr, l, r){
     //code here
         if(l >= r)
             return;
             
         const mid = l + Math.floor((r - l) / 2);
         this.mergeSort(arr, l, mid);
         this.mergeSort(arr, mid + 1, r);
         this.merge(arr, l, mid, r);
    }
    
}