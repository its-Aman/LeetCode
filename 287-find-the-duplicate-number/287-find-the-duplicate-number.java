class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        
        do{
            tortoise = nums[tortoise];
            hare = nums[hare];
            hare = nums[hare];
            // System.out.println("t: " + tortoise + "\t h: " + hare);
        } while(tortoise != hare);
        
        tortoise = nums[0];
        // System.out.println("reset---");
        
        while(tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];            
            // System.out.println("t: " + tortoise + "\t h: " + hare);
        }
        
        // System.out.println("ans: "+hare);
        return hare;
    }
}