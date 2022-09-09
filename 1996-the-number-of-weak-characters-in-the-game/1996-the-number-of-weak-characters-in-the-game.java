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
    
    /*
    
        Our goal is to find a character with two stats higher than our character[i]. ( 1 <= i <= n = len(a) )
        If [5,3] and [5,4] appear at the same time, then B must be better than A.
        So for characters with the same attack, we only need to record the one with the largest defense.
        That is ct[a[i][0]]=max(a[i][1],ct[a[i][0]]); .
        [6,4],[5,5] is always better than [4,3] -> ct[j]=max(ct[j],ct[j+1]~ct[100000]) ( 1 <= j <= 1e5 )
        If ct[j] = max(ct[j]~ct[1e5]), then ct[a[i][0]+1]>a[i][1] means that any a[k] ( 1 <= k <=n, k != i ) is both better than a[i].
        Time complexity is O(n) because both max(a[i]), n <1e5.     
    
    */
    
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