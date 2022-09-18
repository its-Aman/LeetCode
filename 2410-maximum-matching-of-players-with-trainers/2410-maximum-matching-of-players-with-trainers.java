class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ans = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        int N = players.length, M = trainers.length;
        int j = 0;

        for (int i = 0; i < N && j < M; i++) {
            while (trainers[j] < players[i]) {
                ++j;
                if (j == M)
                    return ans;
            }

            if (trainers[j] >= players[i]) {
                ++ans;
                j++;
            }
        }

        return ans;
    }
}