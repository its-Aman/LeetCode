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
		for j := 0; j < len(graph[i]); j++ {
			node := graph[i][j]
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

		for idx := 0; idx < len(adj[node]); idx++ {
			in[adj[node][idx]]--

			if in[adj[node][idx]] == 0 {
				q.Enqueue(adj[node][idx])
			}
		}
	}

	ans := make([]int, 0)

	for i := 0; i < N; i++ {
		if safe[i] {
			ans = append(ans, i)
		}
	}

	return ans
}
