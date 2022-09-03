class Solution {
    Set<Long> uniq = new HashSet<>();

    public int[] numsSameConsecDiff(int N, int K) {
        this.backTrack(new int[N], 0, K);
        return this.toIntArray();
    }

    private void backTrack(int[] num, int idx, int K) {
        var n = this.toNum(num);
        if (this.uniq.contains(n))
            return;

        if (idx == num.length) {
            this.uniq.add(n);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (idx == 0 && i == 0)
                continue;

            if (idx == 0) {
                num[idx] = i;
                this.backTrack(num, idx + 1, K);
            } else {
                int prev = num[idx - 1];
                if (prev - K >= 0) {
                    num[idx] = prev - K;

                    this.backTrack(num, idx + 1, K);
                }
                if (prev + K < 10) {
                    num[idx] = prev + K;
                    this.backTrack(num, idx + 1, K);
                }
            }
        }
    }

    private int[] toIntArray() {
        var res = new int[this.uniq.size()];
        var i = 0;

        var it = this.uniq.iterator();

        while (it.hasNext())
            res[i++] = it.next().intValue();

        return res;
    }

    private long toNum(int[] num) {
        long n = 0;
        for (var d : num) {
            n += d;
            n *= 10;
        }
        return n / 10;
    }

}