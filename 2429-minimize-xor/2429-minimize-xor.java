class Solution {
    public int minimizeXor(int num1, int num2) {
        int bit = Integer.bitCount(num2);
        int ans = 0;

        if (bit == Integer.bitCount(num1))
            return num1;

        for (int i = 31; i >= 0; i--) {
            if (((num1 >> i) & 1) == 1 && bit > 0) {
                ans |= (1 << i);
                bit--;
            }
        }

        for (int i = 0; i < 32; i++) {
            if (bit == 0) break;

            if (((ans >> i) & 1) != 1) {
                ans |= (1 << i);
                bit--;
            }
        }

        return ans;
    }

//     public int minimizeXor(int num1, int num2) {
//         int bit1 = countBit(num1), bit2 = countBit(num2);
//         int num = generateNumber(bit2);

//         if (bit1 == bit2) {
//             return num1;
//         } else {
//             if (bit2 > bit1) {
//                 return generateNumber(bit2 - bit1);
//             } else {
//                 int ans = 0;
//                 int diff = bit1 - bit2;

//                 for (int i = 0; i < 32; i++) {
//                     if ((num1 & (1 << i)) == 1) {
//                         diff--;
//                         ans |= i;
//                     }
//                     if (diff <= 0)
//                         break;
//                 }

//                 return ans;
//             }
//         }
//     }

//     private int generateNumber(int bit) {
//         int ans = 0;
//         while (bit > 0) {
//             ans <<= 1;
//             ans |= 1;
//             bit--;
//         }
//         return ans;
//     }

//     private int countBit(int num) {
//         int ans = 0;

//         while (num > 0) {
//             ans += num & 1;
//             num >>= 1;
//         }

//         return ans;
//     }
}