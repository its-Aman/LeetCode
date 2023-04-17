class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = 0;
        
        for(int candie: candies) {
            max = Math.max(max, candie);
        }
        
        for(int candie: candies) {
            ans.add(candie+extraCandies >= max);
        }

        return ans;
    }
}