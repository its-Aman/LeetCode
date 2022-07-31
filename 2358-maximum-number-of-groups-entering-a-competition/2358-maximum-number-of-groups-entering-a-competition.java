class Solution {
    public int maximumGroups(int[] grades) {
      int K = 0;
      
      while(K*(K+1)/2 <= grades.length)
        K++;
      
      return K - 1;
    }
}