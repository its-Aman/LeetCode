class LUPrefix {
    int idx;
    boolean[] videos;

    public LUPrefix(int n) {
        idx = 0;
        videos = new boolean[n + 1];
    }

    public void upload(int video) {
        videos[video] = true;
    }

    public int longest() {
        while (idx + 1 < videos.length && videos[idx + 1])
            idx++;
        
        return idx;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */