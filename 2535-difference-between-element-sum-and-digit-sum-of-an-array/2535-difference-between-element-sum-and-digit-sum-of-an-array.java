class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int dSum = 0;

        for (int num : nums) {
            sum += num;
            dSum += getSum(num);
        }

        return Math.abs(sum - dSum);
    }

    private int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

}