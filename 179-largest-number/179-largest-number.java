class Solution {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++)
            strArr[i] = Integer.toString(nums[i]);

        // Arrays.sort(strArr, (a, b) -> (b + a).compareTo((a + b)));
        Arrays.sort(strArr, (a, b) -> b.concat(a).compareTo(a.concat(b)));
        String ans = String.join("", strArr);

        if (ans.charAt(0) == '0')
            ans = "0";

        return ans;
    }
}