func smallestSufficientTeam(req_skills []string, people [][]string) []int {
	n, m, skills := len(req_skills), len(people), make(map[string]int)
	dp, ans, pSkills := make([]int, 1<<n), make([][]int, 1<<n), make([]int, m)

	for i := 0; i < n; i++ {
		skills[req_skills[i]] = i
	}

	for i := 0; i < (1 << n); i++ {
		dp[i] = math.MaxInt32
	}

	for i := 0; i < m; i++ {
		for _, s := range people[i] {
			pSkills[i] |= (1 << skills[s])
		}
	}

	dp[0] = 0

	for i := 0; i < m; i++ {

		for mask := 0; mask < (1 << n); mask++ {
			newMask := mask | pSkills[i]

			if dp[mask]+1 < dp[newMask] {
				dp[newMask] = dp[mask] + 1
				ans[newMask] = []int{i}
				ans[newMask] = append(ans[newMask], ans[mask]...)
			}
		}
	}
	
	return ans[(1<<n)-1]
}

func smallestSufficientTeam2(req_skills []string, people [][]string) []int {
	N, M := len(people), len(req_skills)
	skillIds := make(map[string]int, 0)
	skillsMaskOfPerson := make([]int, N)

	for idx, s := range req_skills {
		skillIds[s] = idx
	}

	for i, p := range people {
		for _, s := range p {
			skillsMaskOfPerson[i] |= (1 << skillIds[s])
		}
	}

	dp := make([]int, 1<<M)

	for i, _ := range dp {
		dp[i] = (1 << N) - 1
	}

	dp[0] = 0

	for skillsMask := 1; skillsMask < (1 << M); skillsMask++ {

		for i := 0; i < N; i++ {
			smallerSkillMask := skillsMask & (^skillsMaskOfPerson[i])

			if smallerSkillMask != skillsMask {
				peopleMask := dp[smallerSkillMask] | (1 << i)
				if bits.OnesCount64(uint64(peopleMask)) < bits.OnesCount64(uint64(dp[skillsMask])) {
					dp[skillsMask] = peopleMask
				}
			}
		}
	}

	ansMask := dp[(1<<M)-1]
	ans := make([]int, bits.OnesCount64(uint64(ansMask)))
	ptr := 0
	for i := 0; i < N; i++ {
		if (ansMask>>i)&i == 1 {
			ans[ptr] = i
			ptr++
		}
	}
	return ans
}
