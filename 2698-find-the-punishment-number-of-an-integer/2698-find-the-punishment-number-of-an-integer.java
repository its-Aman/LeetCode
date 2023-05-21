class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;

        for (int i = n, sq = i*i; i > 0; i--, sq = i*i) {
            if (findSum(sq, i)) {
                ans += sq;
            }
        }

        return ans;
    }

    private boolean findSum(int num, int tar) {
        if (num<tar || tar<0) return false;
        if(num==tar) return true;
        return findSum(num/10, tar-num%10)||findSum(num/100, tar-num%100)||findSum(num/1000, tar-num%1000);
    }
}