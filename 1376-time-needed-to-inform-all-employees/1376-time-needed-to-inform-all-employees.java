class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] == 0) continue;
            ans = Math.max(ans, dfs(i, manager, informTime));
        }
        return ans;
    }

    private int dfs(int emp, int[] manager, int[] informTime) {
        if (manager[emp] != -1) {
            informTime[emp] += dfs(manager[emp], manager, informTime);
            manager[emp] = -1;
        }
        return informTime[emp];
    }

    public int numOfMinutes0(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) g.get(manager[i]).add(i);
        }

        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, informTime[headID]});

        while (!q.isEmpty()) {
            var curr = q.poll();
            ans = Math.max(ans, curr[1]);
            for (var next : g.get(curr[0])) {
                q.offer(new int[]{next, curr[1] + informTime[next]});
            }
        }

        return ans;
    }

    public int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        if (n == 0) return 0;
        int[] maxTimes = new int[n + 1];

        for (int i = 0; i < n; i++) {
            maxTimes[manager[i] + 1] = Math.max(maxTimes[manager[i] + 1], informTime[i]);
        }

        System.out.println(Arrays.toString(maxTimes));
        return Arrays.stream(maxTimes).sum();
    }
    
    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        if (n == 0) return 0;
        Map<Integer, Integer> g = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!g.containsKey(manager[i])) {
                g.put(manager[i], informTime[i]);
            } else {
                g.put(manager[i], Math.max(informTime[i], g.get(manager[i])));
            }
        }

        return g.values().stream().reduce((a, b) -> a + b).orElse(-1);
    }
}