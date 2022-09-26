class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean isPresent = false;
        Set<String> set = new HashSet<>();
        
        for(String word: wordList) {
            if(word.equals(endWord))
                isPresent = true;
            set.add(word);
        }
        
        if(!isPresent)
            return 0;

        Queue<String> q = new LinkedList<>();
        int steps = 0;
        q.offer(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            ++steps;
            
            while(size-- > 0) {
                String curr = q.poll();
                
                if(curr.equals(endWord))
                    return steps;
                
                int len = curr.length();

                for(int i = 0; i < len; i++) {
                    
                    for(int j = 0, ch = 'a' + j; j < 26; j++, ch++) {
                        String next = curr.substring(0, i) + (char)ch + curr.substring(i + 1);
                        if(set.contains(next)){
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    
                }
            }            
        }
        
        return 0;
    }
}