class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int item : nums) {
            set.add(item);
            set.add(reverse(item));
        }

        return set.size();
    }

    private int reverse(int i) {
        int rev = 0;
        while (i != 0) {
            rev = rev * 10 + (i % 10);
            i /= 10;
        }
        return rev;
    }
}