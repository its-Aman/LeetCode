class BrowserHistory {
    ArrayList<String> list;
    int curr, last;
        
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
    }
    
    public void visit(String url) {
        curr++;
        
        if(list.size() > curr) {
            list.add(curr, url);    
        } else {
            list.add(url);
        }
        
        last = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return list.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return list.get(curr);
    }
}

class DLNode {
    public String val;
    public DLNode p, n;

    public DLNode(String s) {
        val = s;
    }
}

class BrowserHistory1 {
    DLNode ptr, root;
    
    public BrowserHistory1(String homepage) {
        root = new DLNode(homepage);
        ptr = root;
    }
    
    public void visit(String url) {
        DLNode v = new DLNode(url);
        ptr.n = v;
        v.p = ptr;
        ptr = ptr.n;
    }
    
    public String back(int steps) {
        
        while(steps-- > 0 && ptr.p != null) {
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