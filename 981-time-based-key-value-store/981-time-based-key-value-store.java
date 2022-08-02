class Data {
    String value;
    int time;
    
    public Data(String value, int time){
        this.value = value;
        this.time = time;
    }
}

class TimeMap {
	private HashMap<String, List<Data>> map;

    public TimeMap() {
		this.map = new HashMap<>();
    }
    
	public void set(String key, String value, int timestamp) {
		this.map.putIfAbsent(key, new ArrayList<>());
		this.map.get(key).add(new Data(value, timestamp));
	}

	public String get(String key, int timestamp) {
        if(!this.map.containsKey(key))
            return "";
        
        // binary search
        
        List<Data> dataList = this.map.get(key);
        int lo = 0;
        int hi = dataList.size() - 1;
        
        while(lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if(dataList.get(mid).time <= timestamp)
                lo = mid;
            else
                hi = mid - 1;
        }
        
        return dataList.get(lo).time <= timestamp ? dataList.get(lo).value : "";
	}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */