func longestSubsequence(arr []int, diff int) int {
    dp := make(map[int]int, 0)
    ans := 1
    
    for _, item := range arr {
        prev, _ := dp[item-diff]
        dp[item] = prev + 1
        ans = max(ans, dp[item]);
    }

    return ans
}

func max(x,y int) int {
    if x > y {
        return x
    }
    return y
}