// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/discuss/2876532/Java-or-Beats-100-or-dfs-%2B-bfs
class Solution {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int component = 1;

        for (int node = 1; node <= n; node++) {
            if (visited.contains(node))
                continue;

            visited.add(node);
            components.put(component, new ArrayList<>());
            dfsComponents(component++, node, graph, components, visited);
        }

        int[] componentsMaxTravel = new int[component];
        int finalRes = 0;

        for (int comp = 1; comp < component; comp++) {

            for (int compNode : components.get(comp)) {
                int compRes = bfs(compNode, graph);
                if (compRes == -1)
                    return -1;

                componentsMaxTravel[comp] = Math.max(componentsMaxTravel[comp], compRes);
            }
            finalRes += componentsMaxTravel[comp];
        }

        return finalRes;
    }

    private void dfsComponents(int component, int node, Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> components, Set<Integer> visited) {
        components.get(component).add(node);

        if (!graph.containsKey(node))
            return;

        for (int neighbor : graph.get(node)) {
            if (visited.contains(neighbor))
                continue;

            visited.add(neighbor);
            dfsComponents(component, neighbor, graph, components, visited);
        }
    }

    private int bfs(int node, Map<Integer, List<Integer>> graph) {
        int reach = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> curLevel = new HashSet<>();
        Set<Integer> nextLevel = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            while (n-- > 0) {
                int curNode = queue.poll();
                if (!graph.containsKey(curNode))
                    continue;

                for (int neighbor : graph.get(curNode)) {
                    if (curLevel.contains(neighbor))
                        return -1;

                    if (visited.contains(neighbor))
                        continue;

                    nextLevel.add(neighbor);
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }

            curLevel.clear();
            curLevel.addAll(nextLevel);
            nextLevel.clear();
            reach++;
        }

        return reach;
    }
}