class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqTransformations = new HashSet<>();
        
        for(String word: words) {
            StringBuilder sb = new StringBuilder();
            
            for(char c: word.toCharArray()) {
                sb.append(morse[c-'a']);
            }
            
            System.out.println(sb.toString());
            uniqTransformations.add(sb.toString());
        }
        
        return uniqTransformations.size();
    }
}