class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (var item : nums) {
            set.add(item);
            set.add(reverse(item));
        }

        // System.out.println(set);

        return set.size();
    }

    private int reverse(int i) {
        int rev = 0;
        while (i != 0) {
            int digit = i % 10;
            rev = rev * 10 + digit;
            i /= 10;
        }
        return rev;
    }
}