class ParkingSystem {
    int[] garage = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        garage[1] = big;
        garage[2] = medium;
        garage[3] = small;        
    }
    
    public boolean addCar(int carType) {
        if(garage[carType] == 0) 
            return false;

        --garage[carType];
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */