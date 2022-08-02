import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
	private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
		this.map = new HashMap<>();
    }
    
	public void set(String key, String value, int timestamp) {
		this.map.putIfAbsent(key, new TreeMap<>());
		this.map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> valMap = this.map.get(key);
		if (valMap == null) {
			return "";
		}

		Integer floorKey = valMap.floorKey(timestamp);

		if (floorKey == null) {
			return "";
		}

		return valMap.get(floorKey);
	}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */