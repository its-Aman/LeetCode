class Solution {
    public List<Integer> goodIndices_(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int N = nums.length;

        if(k == 1) {
            for(int i = k; i < N - k; i++)
                ans.add(i);
            return ans;
        }
        
        if (k >= N / 2)
            return ans;

        Queue<Integer> qL = new LinkedList<>(),
                qR = new LinkedList<>();

        for (int i = 0; i < N - k; i++) {

            if (qL.size() < k) {
                while (!qL.isEmpty() && nums[i] > qL.peek())
                    qL.poll();

                qL.offer(nums[i]);
                continue;
            }

            int idx = i + 1;

            while (idx <= i + k) {
                while (!qR.isEmpty() && nums[idx] < qR.peek())
                    qR.poll();

                qR.offer(nums[idx]);
                idx++;
            }

            if (qR.size() >= k && qL.size() >= k)
                ans.add(i);

            if (!qL.isEmpty() && qL.size() >= k) {
                qL.poll();
                qL.offer(nums[i]);
            }

            if (!qR.isEmpty() && qR.size() >= k) {
                qR.poll();
            }

        }

        return ans;
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int N = nums.length;
        int[] prefixSum = new int[N + 1];
        int[] suffixSum = new int[N + 1];

        Arrays.fill(prefixSum, 1);
        Arrays.fill(suffixSum, 1);

        for (int i = 1; i < N; i++) {

            if (nums[i - 1] >= nums[i])
                prefixSum[i] = prefixSum[i - 1] + 1;

            int idx = N - 1 - i;

            if (nums[idx] <= nums[idx + 1])
                suffixSum[idx] = suffixSum[idx + 1] + 1;
        }

        // System.out.printf("%d\t%s\t%s\n", k, Arrays.toString(prefixSum), Arrays.toString(suffixSum));

        for (int i = k; i < N - k; i++) {
            if (prefixSum[i - 1] >= k && suffixSum[i + 1] >= k)
                ans.add(i);
        }

        return ans;
    }
    
}