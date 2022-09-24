class RandomizedSet {

    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        map.remove(val);
        return true;
    }

    public int getRandom() {
        int rand = random.nextInt(map.size());
        var it = map.keySet().iterator();

        while (it.hasNext() && rand-- > 0)
            it.next();

        return it.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */