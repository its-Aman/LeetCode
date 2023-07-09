func largestVariance(s string) int {
	cnt := make([]int, 26)
	ans := 0

	for i := 0; i < len(s); i++ {
		cnt[s[i]-'a']++
	}

	for l := 0; l < 26; l++ {
		for h := 0; h < 26; h++ {
			if l == h || cnt[l] == 0 || cnt[h] == 0 {
				continue
			}

			major, minor := rune(l+'a'), rune(h+'a')
			majorCnt, minorCnt := 0, 0
			resetMinor := cnt[h]

			for i := 0; i < len(s); i++ {

				if major == rune(s[i]) {
					majorCnt++
				}

				if minor == rune(s[i]) {
					minorCnt++
					resetMinor--
				}

				if minorCnt > 0 {
					ans = max(ans, majorCnt-minorCnt)
				}

				if majorCnt < minorCnt && resetMinor > 0 {
					majorCnt = 0
					minorCnt = 0
				}

			}
		}
	}
    
	return ans
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
