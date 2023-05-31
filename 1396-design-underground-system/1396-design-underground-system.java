class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> in;
    Map<String, Pair<Double, Integer>> avg;
    

    public UndergroundSystem() {
        this.in = new HashMap<>();
        this.avg = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        this.in.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        var start = this.in.get(id);
        this.in.remove(id);
        
        String routeKey = start.getKey()+"_"+stationName;
        double time = t-start.getValue();
        
        if(!this.avg.containsKey(routeKey)) {
            this.avg.put(routeKey, new Pair(time, 1));    
        } else {
            var curr = this.avg.get(routeKey);
            this.avg.put(routeKey, new Pair(time+curr.getKey(), 1+curr.getValue()));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        var routeKey = startStation+"_"+endStation;
        var trip = this.avg.get(routeKey);
        return trip.getKey()/trip.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */