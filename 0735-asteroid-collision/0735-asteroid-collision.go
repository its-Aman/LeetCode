import stack "github.com/emirpasic/gods/stacks/arraystack"

func asteroidCollision(asteroids []int) []int {
	stk := stack.New()

	for _, asteroid := range asteroids {
		for asteroid < 0 && !stk.Empty() {
			item, _ := stk.Peek()

			if item.(int) <= 0 {
				break
			}
            
            stk.Pop()

			if item.(int)+asteroid == 0 {
				asteroid = 0
			} else if item.(int)+asteroid > 0 {
				asteroid = item.(int)
			}
		}

		if asteroid != 0 {
			stk.Push(asteroid)
		}
	}

	ans := make([]int, stk.Size())

	for stk.Size() > 0 {
		item, ok := stk.Pop()
		if !ok {
			break
		}
		ans[stk.Size()] = item.(int)
	}

	return ans
}
