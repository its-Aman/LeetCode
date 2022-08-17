class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqTransformations = new HashSet<>();
        
        for(String word: words) {
            String curr = new String();
            for(char c: word.toCharArray()) {
                curr = curr.concat(morse[c-'a']);
            }
            
            uniqTransformations.add(curr);
        }
        
        return uniqTransformations.size();
    }
}