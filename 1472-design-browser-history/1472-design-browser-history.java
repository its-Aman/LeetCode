class DLNode {
    public String val;
    public DLNode p, n;

    public DLNode(String s) {
        val = s;
    }
}

class BrowserHistory {
    DLNode ptr, root = new DLNode("");
    
    public BrowserHistory(String homepage) {
        DLNode node = new DLNode(homepage);
        root.n = node;
        node.p = root;
        ptr = node;
    }
    
    public void visit(String url) {
        DLNode v = new DLNode(url);
        v.p = ptr;
        ptr.n = v;
        ptr = ptr.n;
    }
    
    public String back(int steps) {
        
        while(steps-- > 0 && ptr.p.val != "") {
            ptr = ptr.p;
        }
                
        return ptr.val;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && ptr.n != null) {
            ptr = ptr.n;
        }

        return ptr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */


class BrowserHistory2 {
    Stack<String> f, b;
    String start;

    public BrowserHistory2(String homepage) {
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