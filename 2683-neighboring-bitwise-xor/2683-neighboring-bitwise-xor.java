class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int cnt = 0;

        for (int d: derived) cnt += d;
        
        return cnt % 2 == 0;
    }
}