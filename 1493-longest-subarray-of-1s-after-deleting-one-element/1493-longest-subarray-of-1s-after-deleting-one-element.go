func longestSubarray(nums []int) int {
    i:=0
    ans:=0
    idx:=-1
    
    for j:= range nums {
        if nums[j]==0 {
            i=idx+1;
            idx=j
        }
        ans=max(ans, j-i)
    }
    return ans
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}