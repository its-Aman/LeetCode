import (
	llq "github.com/emirpasic/gods/queues/linkedlistqueue"
)

func eventualSafeNodes(graph [][]int) []int {
	N := len(graph)
	in, adj, safe := make([]int, N), make([][]int, N), make([]bool, N)
	q := llq.New()

	for i := 0; i < N; i++ {
		adj[i] = make([]int, 0)
	}

	for i := 0; i < N; i++ {
		for _, node := range graph[i] {
			adj[node] = append(adj[node], i)
			in[i]++
		}

		if in[i] == 0 {
			q.Enqueue(i)
		}
	}

	for !q.Empty() {
		item, ok := q.Dequeue()
		if !ok {
			continue
		}
		node := item.(int)
		safe[node] = true

		for _, nbr := range adj[node] {
			in[nbr]--

			if in[nbr] == 0 {
				q.Enqueue(nbr)
			}
		}
	}

	ans := make([]int, 0)

	for i, isSafe := range safe {
		if isSafe {
			ans = append(ans, i)
		}
	}

	return ans
}