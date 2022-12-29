class Solution {
    public int[] getOrder(int[][] tasks) {
        int N = tasks.length;
        int[] ans = new int[N];
        int[][] sortedTasks = new int[N][3];
        long currTime = 0;
        int taskIdx = 0, ansIdx = 0;
        
        PriorityQueue<int[]> nextTask = new PriorityQueue<>(
            (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]
        );
        
        for(int i = 0; i < N; i++) {
            sortedTasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        
        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));
        
        while(taskIdx < N || !nextTask.isEmpty()) {
            if(nextTask.isEmpty() && currTime < sortedTasks[taskIdx][0]) {
                currTime = sortedTasks[taskIdx][0];
            }
            
            while(taskIdx < N && currTime >= sortedTasks[taskIdx][0]) {
                nextTask.offer(sortedTasks[taskIdx]);
                taskIdx += 1;
            }
            
            int processTime = nextTask.peek()[1];
            int idx = nextTask.peek()[2];
            nextTask.poll();
            
            currTime += processTime;
            ans[ansIdx++] = idx;
        }
        
        return ans;
    }
}