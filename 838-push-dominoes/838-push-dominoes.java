class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        char[] D = dominoes.toCharArray();
        int[] forces = new int[N];
        int currForce = 0;

        for (int i = 0; i < N; i++) {
            if (D[i] == 'R')
                currForce = N;
            else if (D[i] == 'L')
                currForce = 0;
            else
                currForce = Math.max(currForce - 1, 0);
            forces[i] += currForce;
        }

        currForce = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (D[i] == 'L')
                currForce = N;
            else if (D[i] == 'R')
                currForce = 0;
            else
                currForce = Math.max(currForce - 1, 0);
            forces[i] -= currForce;
        }

        for (int i = 0; i < N; i++) {
            if (forces[i] < 0)
                D[i] = 'L';
            else if (forces[i] > 0) {
                D[i] = 'R';
            } else {
                D[i] = '.';
            }
        }

        return String.valueOf(D);
    }
}