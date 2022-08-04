class Solution {
    public int mirrorReflection(int p, int q) {
        double P = p;
        double Q = q;
        
        while(P % 2 == 0 && Q % 2 == 0) {
            P /= 2;
            Q /= 2;
        }
        
        if(P % 2 == 0)
            return 2;
        else if(Q % 2 == 0)
            return 0;
        else 
            return 1;
    }
}
