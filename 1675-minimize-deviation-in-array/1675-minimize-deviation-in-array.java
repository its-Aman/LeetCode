class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int num: nums) {
            if(num % 2 == 1) {
                num += num;
            }
            set.add(num);
        }
        
        int diff = Integer.MAX_VALUE;
        
        while(true) {
            int max = set.last(), min = set.first();
            diff = Math.min(diff, max - min);
            if(max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                return diff;
            }
        }
    }
    
    public int minimumDeviation2(int[] nums) {
        int N = nums.length, min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(N, Collections.reverseOrder());
        
        for(int num: nums) {
            if(num % 2 == 1) {
                num += num;
            }
            maxHeap.offer(num);
            min = Math.min(min, num);
        }

        while(maxHeap.peek() % 2 == 0) {
            int top = maxHeap.poll();
            ans = Math.min(ans, top - min);
            min = Math.min(min, top / 2);
            maxHeap.offer(top / 2);
        }

        ans = Math.min(ans, maxHeap.peek() - min);
        return ans;
    }
}