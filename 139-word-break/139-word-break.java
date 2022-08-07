// https://www.youtube.com/watch?v=Sx9NNgInc3A

class Solution {
    public boolean wordBreak(String S, List<String> wordDict) {
        int N = S.length();
        boolean[] dp = new boolean[N + 1];
        
        // this is the base condition. 
        // means, we assume that the complete string 
        // is part of the dict.
        
        dp[N] = true;
        
        // we start traversing in reverse since we want to keep track of the 
        // words that are present in the dict from the last.
        // this will reduct our comparison for the `i + word.length()` check,
        // because we've already checked it in the reverse traversing.
        
        for(int i = N - 1; i >= 0; i--) {
            for(String word: wordDict) {
                
                // here, `i + word.length() <= N` is checking the bound for the 
                // current sliced string. If it can be sliced, we slice it and compare 
                // it with the original word.
                
                if(i + word.length() <= N && S.substring(i, i + word.length()).equals(word))
                    // here, we're checking from the previous index if there was any word that started 
                    // from index `i + word.length()` in S and it was present in the dict.
                    // since the current word is in the dict, if the dp[i + word.length()]
                    // holds true, that means we've all the words that matches in dict 
                    // till `i`.
                    dp[i] = dp[i + word.length()];

                // break here because we found a word in 
                // the dict and no need to check for 
                // another word since the requirement is to find
                // at least one word.
                if(dp[i])
                    break;
            }
        }
        
        return dp[0];
    }
}