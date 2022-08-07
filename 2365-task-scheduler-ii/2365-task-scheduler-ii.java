// https://leetcode.com/problems/task-scheduler-ii/discuss/2388880/C%2B%2B-Solution-Hindi-explanation-MAP

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long currTime = 0;
        Map<Integer, Long> map = new HashMap<>();
        
        for(int i = 0; i < tasks.length; i++) {
                
//             if(map.containsKey(tasks[i]) && map.get(tasks[i]) > currTime) {
//                 currTime = map.get(tasks[i]);                
//             }
            
//             map.put(tasks[i], 1 + currTime + space);
//             currTime += 1;
            
            map.put(tasks[i], 1 + space + (currTime = Math.max(currTime, map.getOrDefault(tasks[i], currTime))));
            currTime += 1;

        }

        
        return currTime;
    }
}