class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> tally = new Stack<>();
        
        for(int asteroid: asteroids) {
            
            while(asteroid < 0 && !tally.isEmpty() && tally.peek() > 0) {
                int topAsteroid = tally.pop();
                int whatsLeft = topAsteroid + asteroid;
                
                if(whatsLeft == 0)
                    asteroid = 0;
                else if(whatsLeft > 0)
                    asteroid = topAsteroid;
            }

            if(asteroid != 0)
                tally.push(asteroid);
                    
        }
        
        int[] ans = new int[tally.size()];
        while(!tally.isEmpty())
            ans[tally.size() - 1] = tally.pop();
        
        return ans;
    }
}