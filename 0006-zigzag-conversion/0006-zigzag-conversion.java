class Solution {
    public String convert(String s, int R) {
        if(R == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int N = s.length();
        int charInSec = 2 * (R - 1);

        for(int r = 0; r < R; r++) {
            int idx = r;
            
            while(idx < N) {
                sb.append(s.charAt(idx));
                
                if(r != 0 && r != R - 1) {
                    int charInBw = charInSec - 2 * r;
                    int nextIdx = idx + charInBw;
                    
                    if(nextIdx < N) {
                        sb.append(s.charAt(nextIdx));
                    }
                }
                
                idx += charInSec;
            }
        }
        
        return sb.toString();
    }
    
    public String convert2(String s, int R) {
        if(R == 1) {
            return s;
        }
        
        int N = s.length();
        int C = (int)Math.ceil(N / (2*(R - 2)) * (R - 1));
        char[][] mat = new char[R][C];

        for(var rows: mat) {
            Arrays.fill(rows, ' ');
        }

        int _R = 0, _C = 0, idx = 0;
        
        while(idx < N) {
            
            while(_R < R && idx < N) {
                mat[_R][_C] = s.charAt(idx);
                _R++;
                idx++;
            }
            
            _R -= 2;
            _C++;
            
            while(_R > 0 && _C < C && idx < N) {
                mat[_R][_C] = s.charAt(idx);
                _R--;
                _C++;
                idx++;                
            }
        }
            
        StringBuilder sb = new StringBuilder();
        
        for(var rows: mat) {
            for(var c: rows) {
                if(c != ' ') {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}