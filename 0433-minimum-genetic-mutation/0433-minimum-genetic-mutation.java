class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Set<String> set = new HashSet<>();
        char[] genes = new char[]{'A', 'C', 'G', 'T'};

        for (String b : bank)
            set.add(b);

        q.add(start);
        seen.add(start);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                char[] node = q.poll().toCharArray();

                if (String.valueOf(node).equals(end))
                    return steps;

                for (char c : genes) {
                    for (int i = 0; i < 8; i++) {
                        char temp = node[i];
                        node[i] = c;
                        String nbr = String.valueOf(node);
                        if (!seen.contains(nbr) && set.contains(nbr)) {
                            q.add(nbr);
                            seen.add(nbr);
                        }
                        node[i] = temp;
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}