class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int[] flatBoard = new int[N * N];

        for (int r = N - 1; r >= 0; r--) {
            boolean leftDir = (N - r) % 2 == 1;
            for (int c = leftDir ? 0 : N - 1; leftDir ? c < N : c >= 0; c += leftDir ? 1 : -1) {
                flatBoard[getIdx(r, c, N) - 1] = board[r][c];
            }
        }

        int[] dist = new int[N * N];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        dist[0] = 0;
        q.offer(0);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next = curr + 1; next <= Math.min(curr + 6, N * N - 1); next++) {
                int dest = flatBoard[next] == -1 ? next : flatBoard[next] - 1;
                if (dist[dest] == -1) {
                    dist[dest] = dist[curr] + 1;
                    q.offer(dest);
                }
            }
        }

        return dist[N * N - 1];
    }

    private int getIdx(int r, int c, int N) {
        return (N - r - 1) * N + ((N - r) % 2 == 0 ? (N - c) : c + 1);
    }
    
/*
    int[] flatBoard;
    int N;
    Set<Integer> vis = new HashSet<>();

    public int snakesAndLadders(int[][] board) {
        N = board.length;
        flatBoard = new int[N * N];

        for (int r = N - 1; r >= 0; r--) {
            boolean leftDir = (N - r) % 2 == 1;
            for (int c = leftDir ? 0 : N - 1; leftDir ? c < N : c >= 0; c += leftDir ? 1 : -1) {
                flatBoard[getSteps(r, c, N) - 1] = board[r][c];
            }
        }

        // System.out.println(Arrays.toString(flatBoard));
        return minCost(-1, -1) - 1;
    }

    private int minCost(int idx, int cnt) {
        // System.out.printf("idx: %d\tcnt:%d\n", idx, cnt);
        
        if(vis.contains(idx)) {
            return Integer.MAX_VALUE;
        }
        vis.add(idx);

        if (idx + 1 == N * N) {
            return cnt;
        }

        int cost = Integer.MAX_VALUE;

        for (int i = idx + 1; i <= Math.min(idx + 6, N * N - 1); i++) {
            if (flatBoard[i] == -1) {
                cost = Math.min(cost, minCost(i, cnt + 1));
            } else {
                cost = Math.min(cost, minCost(flatBoard[i] - 1, cnt + 1));
            }
        }

        return cost;
    }

    private int getSteps(int r, int c, int N) {
        return (N - r - 1) * N + ((N - r) % 2 == 0 ? (N - c) : c + 1);
    }
*/    
    
//     int N;
    
//     public int snakesAndLadders(int[][] board) {
//         N = board.length;
//         return minSteps(board, 0, N - 1, 0);
//     }
    
//     private int minSteps(int[][] board, int cnt, int r, int c) {
//         if(getSteps(r, c) == N * N) {
//             return cnt;
//         }
        
//         int min = Integer.MAX_VALUE;
        
//         // for(int i = c + 1; i <= Math.min(c + 6, N); i += (N - r) % 2 == 0 ? -1 : 1) {
        
//         for(int i = 0; i < 6; i++) {

//             if((N - r) % 2 == 1) {
//                 int nc = c + i >= N ? N - 1 - (N - i)
//                 int nr = r + (c + i) >= N ? 1 : 0;
//                 min = Math.min(minSteps(board, cnt + 1, ))
                
//             }
        
//         }
//     }
    
//     private int getSteps(int r, int c) {
//         return (N - r - 1) * N + ((N - r) % 2 == 0 ? (N - c) : c + 1);
//     }
}