class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int N = num.length, c = 0, i = N - 1;
        List<Integer> ans = new ArrayList<>();
        boolean isTrue = true;
        
        while(isTrue) {
            int x = c;
            
            if(i >= 0) {
                x += num[i];
                i--;
                isTrue = i >= 0;
            } else {
                isTrue = false;
            }
            
            if(k > 0) {
                x += k % 10;    
                k /= 10;
                isTrue = isTrue || (k > 0);
            } else {
                isTrue = isTrue || false;
            }

            ans.add(x % 10);
            c = x / 10;
        }
        
        if(c > 0) {
            ans.add(c);
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}