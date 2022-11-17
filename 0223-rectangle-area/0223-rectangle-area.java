class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return calculateArea(ax1, ay1, ax2, ay2) + 
                calculateArea(bx1, by1, bx2, by2) - 
                overlap(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }
    
    private int overlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0) * Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);
    }
    
    private int calculateArea(int ax1, int ay1, int ax2, int ay2) {
        int area = (ay2 - ay1) * (ax2 - ax1);
        return Math.max(area, 0);
    }
}