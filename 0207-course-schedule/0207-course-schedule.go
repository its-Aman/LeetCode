import "container/list"

func canFinish(numCourses int, prerequisites [][]int) bool {
	seen := make([]bool, numCourses)
	hMap := make(map[int][]int, numCourses)
	stk := list.New()

	for _, item := range prerequisites {
		_, ok := hMap[item[0]]
		if !ok {
			hMap[item[0]] = make([]int, 0)
		}
		hMap[item[0]] = append(hMap[item[0]], item[1])
	}

	var hasCycle func(int) bool

	hasCycle = func(v int) bool {
		if seen[v] {
			for item := stk.Front(); item != nil; item = item.Next() {
				if item.Value == v {
					return true
				}
			}
			return false
		}

		seen[v] = true
		stk.PushBack(v)

		for _, val := range hMap[v] {
			if hasCycle(val) {
				return true
			}
		}

		stk.Remove(stk.Back())
		return false
	}

	for i := 0; i < numCourses; i++ {
		if hasCycle(i) {
			return false
		}
	}

	return true
}