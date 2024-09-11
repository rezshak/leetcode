// https://leetcode.com/problems/design-parking-system/

class ParkingSystem {

    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[] { 0, big, medium, small };
    }

    // T: O(1), S: O(1)
    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var ps = new ParkingSystem(1, 1, 0);
        System.out.println(ps.addCar(1)); // true
        System.out.println(ps.addCar(2)); // true
        System.out.println(ps.addCar(3)); // false
    }
}
