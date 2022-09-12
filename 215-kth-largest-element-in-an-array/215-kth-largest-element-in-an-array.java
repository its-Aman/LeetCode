class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = (int)10e4;
        int[] keep = new int[N * 2 + 2];
        
        for(int num: nums)
            ++keep[num + N];
        
        int i = -1;
        for(i = N * 2 + 1; i >= 0 && k > 0; i--)
            k -= keep[i] == Integer.MAX_VALUE ? 0 : keep[i];
        
        return i - N + 1;
    }
}
// 200002