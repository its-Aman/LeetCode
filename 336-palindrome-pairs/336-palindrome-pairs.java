class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int N = words.length;
        for (int i = 0; i < N; i++) {
            wordMap.put(words[i], i);
            set.add(words[i].length());
        }

        List<List<Integer>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int length = words[i].length();
            if (length == 1) {
                if (wordMap.containsKey("")) {
                    result.add(Arrays.asList(i, wordMap.get("")));
                    result.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }
            sb.setLength(0);
            sb.append(words[i]);
            sb.reverse();
            String reverse = sb.toString();

            if (wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                result.add(Arrays.asList(i, wordMap.get(reverse)));

            for (Integer k : set) {
                if (k == length)
                    break;

                if (isPalindrome(reverse, 0, length - 1 - k)) {
                    String s1 = reverse.substring(length - k);
                    if (wordMap.containsKey(s1))
                        result.add(Arrays.asList(i, wordMap.get(s1)));
                }

                if (isPalindrome(reverse, k, length - 1)) {
                    String s2 = reverse.substring(0, k);
                    if (wordMap.containsKey(s2))
                        result.add(Arrays.asList(wordMap.get(s2), i));
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }
    
}