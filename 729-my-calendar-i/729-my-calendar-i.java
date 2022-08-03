class MyCalendar {
	TreeSet<Pair<Integer, Integer>> times;

    public MyCalendar() {
		this.times = new TreeSet<>((a, b) -> a.getKey() - b.getKey());
	}

	public boolean book(int start, int end) {
		Pair<Integer, Integer> time = new Pair<Integer, Integer>(start, end);

		if (this.times.size() == 0) {
			this.times.add(time);
			return true;
		}
        
		Pair<Integer, Integer> ceil = this.times.ceiling(time);
		Pair<Integer, Integer> floor = this.times.floor(time);
        
		if (ceil == null) {
			// check for floor
			if (time.getKey() >= floor.getValue()) {
				this.times.add(time);
				return true;
			} else {
				return false;
			}
		}
		if (floor == null) {
			// check for ceil
			if (time.getValue() <= ceil.getKey()) {
				this.times.add(time);
				return true;
			} else {
				return false;
			}
		}
		if (time.getKey() >= floor.getValue() && time.getValue() <= ceil.getKey()) {
			this.times.add(time);
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