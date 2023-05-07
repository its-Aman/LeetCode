class FrequencyTracker {
    int[] cnt = new int[100001], freq = new int[100001];

    public FrequencyTracker() {
    }

    public void add(int number) {
        if (freq[cnt[number]] > 0) {
            freq[cnt[number]]--;
        }

        cnt[number]++;
        freq[cnt[number]]++;
    }

    public void deleteOne(int number) {
        if (cnt[number] <= 0) return;

        freq[cnt[number]]--;
        cnt[number]--;
        freq[cnt[number]]++;
    }

    public boolean hasFrequency(int frequency) {
        return freq[frequency] > 0;
    }
}