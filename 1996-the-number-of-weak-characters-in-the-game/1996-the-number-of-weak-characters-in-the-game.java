class Solution {
    public int numberOfWeakCharacters_NlogN(int[][] properties) {
        int max_defence = 0, ans = 0;
        Arrays.sort(properties, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        for (int[] prop : properties) {
            ans += prop[1] < max_defence ? 1 : 0;
            max_defence = Math.max(max_defence, prop[1]);
        }

        return ans;
    }
    
    public int numberOfWeakCharacters(int[][] properties) {
        int maxAttack = 0;
        // Find the maximum atack value
        for (int[] property : properties) {
            int attack = property[0];
            maxAttack = Math.max(maxAttack, attack);
        }

        int maxDefense[] = new int[maxAttack + 2];
        // Store the maximum defense for an attack value
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];

            maxDefense[attack] = Math.max(maxDefense[attack], defense);
        }

        // Store the maximum defense for attack greater than or equal to a value
        for (int i = maxAttack - 1; i >= 0; i--) {
            maxDefense[i] = Math.max(maxDefense[i], maxDefense[i + 1]);
        }

        int weakCharacters = 0;
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];

            // If their is a greater defense for properties with greater attack
            if (defense < maxDefense[attack + 1]) {
                weakCharacters++;
            }
        }

        return weakCharacters;
    }
}