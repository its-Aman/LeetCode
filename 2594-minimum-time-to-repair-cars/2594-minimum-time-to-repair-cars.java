class Solution {
    public long repairCars(int[] ranks, int cars) {
        long lo = 0, hi = (long)1e14;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2, carsRepaired = 0;

            for (long rank : ranks) {
                carsRepaired += Math.sqrt(mid / rank);
            }

            if (carsRepaired >= cars) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
}