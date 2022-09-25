class Solution {
    public int trap(int[] height) {
        return trap_2Pointer(height);
    }    

    public int trap_2Pointer(int[] height) {
        int N = height.length, ans = 0;
        int l = 0, r = N - 1;
        int lMax = 0, rMax = 0;

        while (l < r)
            if (height[l] < height[r])
                if (height[l] > lMax)
                    lMax = height[l++];
                else
                    ans += lMax - height[l++];
            else
                if (height[r] > rMax)
                    rMax = height[r--];
                else
                    ans += rMax - height[r--];

        return ans;
    }
    
    public int trap_Stack(int[] height) {
        int N = height.length, ans = 0;
        Stack<Integer> mono = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!mono.isEmpty() && height[i] > height[mono.peek()]) {
                int idx = mono.pop();
                if (mono.isEmpty())
                    break;
                int dist = i - mono.peek() - 1;
                int boundedHeight = Math.min(height[i], height[mono.peek()]) - height[idx];

                ans += dist * boundedHeight;
            }
            mono.push(i);
        }

        return ans;
    }
    
    public int trap_DP(int[] height) {
        int N = height.length, ans = 0;

        if (N == 0) return ans;

        int[] leftMax = new int[N],
                rightMax = new int[N];

        leftMax[0] = height[0];
        rightMax[N - 1] = height[N - 1];

        for (int i = 1; i < N; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        for (int i = N - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        for (int i = 1; i < N - 1; i++)
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];

        return ans;
    }

    public int trap_again(int[] height) {
        int N = height.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int idxOfLastMaxHeight = stack.pop();
                
                if(stack.isEmpty())
                    break;
                
                int distance = (i - 1) - stack.peek();
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[idxOfLastMaxHeight];
                ans += distance * boundedHeight;
            }
            
            stack.push(i);           
        }
        
        return ans;
    }
}