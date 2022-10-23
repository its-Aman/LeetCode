class Solution {
    public int[] findErrorNums(int[] nums) {
        int N = nums.length;
        int[] freq = new int[N+1];
                
        for(int num: nums) 
            ++freq[num];
        
        int x = -1, y = -1;
        
        for(int num = 1; num < freq.length; num++){
            if(freq[num] == 2) {
                x = num;
                if(y != -1) break;
            }
            
            if(freq[num] == 0) {
                y = num;
                if(x != -1) break;
            }
        }

        return new int[]{x, y};
    }
}