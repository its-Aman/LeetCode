// https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/discuss/2357789/JavaC%2B%2BPython-One-line-O(1)

class Solution {
//     public int maximumGroups(int[] grades) {
//       int K = 0;
      
//       while(K*(K+1)/2 <= grades.length)
//         K++;
      
//       return K - 1;
//     }

    public int maximumGroups(int[] grades) {
      return (int)(Math.sqrt(2 * grades.length + 0.25) - 0.5);
    }
}