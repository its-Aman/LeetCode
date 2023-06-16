class Solution {
    private static final long MOD = (long)1e9+7;
    
    public int numOfWays(int[] nums) {
        int N = nums.length;
        List<Integer> arr = new ArrayList<>(N);
        long[][] triangle = new long[N+1][N+1];
                
        for(int num:nums) {
            arr.add(num);
        }

        for(int i=0; i<N; i++) {
            triangle[i][0] = triangle[i][i] = 1;
        }

        for(int i=2; i<N; i++) {
            for(int j=1; j<i; j++) {
                triangle[i][j] = (triangle[i-1][j] + triangle[i-1][j-1]) % MOD;
            }
        }
        
        return (int)getCombs(arr, triangle)-1;
    }
    
    private long getCombs(List<Integer> nums, long[][] combs) {
        if(nums.size() <= 2) return 1;
            
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        
        for(int num: nums) {
            if(num<root) left.add(num);
            else if(num>root) right.add(num);
        }

        long leftCombs = getCombs(left, combs) % MOD;
        long rightCombs = getCombs(right, combs) % MOD;
        
        return (
            combs[left.size()+right.size()][right.size()]*((leftCombs*rightCombs) % MOD)
        ) % MOD;
    }
}