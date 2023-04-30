class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = getScore(player1), 
            s2 = getScore(player2);
        
        if (s1 == s2) {
            return 0;
        } else if (s1 > s2) {
            return 1;
        } else {
            return 2;
        }
    }

    private int getScore(int[] player) {
        int score = 0;

        for (int i = 0, cnt = 0; i < player.length; i++) {
            if (cnt > 0) {
                score += player[i];
            }

            score += player[i];
            cnt--;

            if (player[i] == 10) {
                cnt = 2;
            }
        }
        
        return score;
    }
}