class Solution {
    private int reverse(int i) {
        int rev = 0;
        while (i != 0) {
            int digit = i % 10;
            rev = rev * 10 + digit;
            i /= 10;
        }
        return rev;
    }

    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0)
            return true;
        
        for (int i = 0; i < num; i++) {
            if ((long) (i + reverse(i)) == (long) num)
                return true;
        }

        return false;
    }
}