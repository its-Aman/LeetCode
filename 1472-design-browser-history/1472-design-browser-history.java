class BrowserHistory {
    Stack<String> f, b;
    String start;

    public BrowserHistory(String homepage) {
        f = new Stack<>();
        b = new Stack<>();

        start = homepage;
    }
    
    public void visit(String url) {
        f.push(url);
        b.clear();
    }
    
    public String back(int steps) {        
        while(steps-- > 0 && !f.isEmpty()) {
            b.push(f.pop());
        }
        
        if(f.isEmpty()) {
            return start;
        }

        return f.peek();
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && !b.isEmpty()) {
            f.push(b.pop());
        }

        if(f.isEmpty()) {
            return start;
        }

        return f.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */