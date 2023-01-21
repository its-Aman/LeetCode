import java.math.BigInteger;

class Solution {

    public boolean isReachable(int x, int y) {
		return BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).bitCount() == 1;
    }
}