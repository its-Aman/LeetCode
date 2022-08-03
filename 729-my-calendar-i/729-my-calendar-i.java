class MyCalendar {
	TreeMap<Integer, Integer> times;

    public MyCalendar() {
		this.times = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer next = this.times.ceilingKey(start);
		Integer prev = this.times.floorKey(start);

		if ((prev == null || this.times.get(prev) <= start) && (next == null || end <= next)) {
			this.times.put(start, end);
			return true;
		} else {
			return false;
		}
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */