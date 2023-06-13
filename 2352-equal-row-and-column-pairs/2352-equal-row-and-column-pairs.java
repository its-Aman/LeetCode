class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int r=0; r<grid.length; r++) {
            sb.setLength(0);
            for(int c=0; c<grid[0].length; c++) {
                sb.append(grid[r][c]);
                sb.append('|');
            }
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        
        for(int c=0; c<grid[0].length; c++) {
            sb.setLength(0);
            for(int r=0; r<grid.length; r++) {
                sb.append(grid[r][c]);
                sb.append('|');
            }

            String str = sb.toString();
            if(map.containsKey(str)) {
                ans+=map.get(str);
            } else {
                map.put(str, map.getOrDefault(str, 0)+1);
            }
        }

        return ans;
    }
}