class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        if(set.size() == 0 || !set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        int steps = 0;
        q.offer(beginWord);
        set.remove(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            ++steps;
            
            while(size-- > 0) {
                String curr = q.poll();
                
                if(curr.equals(endWord))
                    return steps;
                
                char[] charArray = curr.toCharArray();

                for(int i = 0; i < charArray.length; i++) {
                    char original = charArray[i];
                    
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                    
                        if(ch == original)
                            continue;
                        
                        charArray[i] = ch;;
                        
                        String next = String.valueOf(charArray);
                        
                        if(set.contains(next)){
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    
                    charArray[i] = original;
                }
            }            
        }
        
        return 0;
    }
}