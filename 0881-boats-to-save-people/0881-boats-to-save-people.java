class Solution {
    
    public int numRescueBoats(int[] people, int k) {
        int ans = 0, N = people.length,
            i = 0, j = N - 1;
        
        Arrays.sort(people);
        
        while(i <= j) {
            ans++;
            
            if(people[i] + people[j] <= k) {
                i++;
            }

            j--;
        }
        
        return ans;
    }    
}