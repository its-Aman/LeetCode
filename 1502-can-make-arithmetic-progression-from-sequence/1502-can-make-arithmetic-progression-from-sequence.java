class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, N = arr.length;
        
        for(int num: arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if(max-min == 0) return true;

        if((max-min)%(N-1)!=0) return false;
        
        int diff = (max-min)/(N-1);
        Set<Integer> set = new HashSet<>();
        
        for(int num: arr) {
            if((num-min)%diff != 0) return false;
            set.add(num);
        }
        
        return set.size()==N;
    }
    
    public boolean canMakeArithmeticProgression2(int[] arr) {
        Arrays.sort(arr);
        
        int diff = arr[0]-arr[1];
        
        for(int i=1; i<arr.length-1; i++) {
            if(diff != arr[i]-arr[i+1]) return false;
        }
        
        return true;
    }
}