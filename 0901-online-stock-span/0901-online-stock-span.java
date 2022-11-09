class StockSpanner {
    Stack<int[]> stack = new Stack<>();
    
    public StockSpanner() { }

    public int next(int price) {
        int cnt = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            cnt += stack.pop()[1];

        stack.push(new int[]{price, cnt});
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */