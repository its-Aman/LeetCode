class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        
        long chemistry = 0;
        int N = skill.length,
            sum = skill[0] + skill[N - 1];

        for (int i = 0; i < N / 2; i++) {
            if (skill[i] + skill[N - 1 - i] != sum)
                return -1;
            chemistry += skill[i] * skill[N - 1 - i];
        }

        return chemistry;
    }
}