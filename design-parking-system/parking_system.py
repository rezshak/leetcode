# https://leetcode.com/problems/design-parking-system/

class ParkingSystem:

    def __init__(self, big, medium, small: int):
        self.slots = [0, big, medium, small]

    # T: O(1), S: O(1)
    def addCar(self, carType: int) -> bool:
        if self.slots[carType] > 0:
            self.slots[carType] -= 1
            return True

        return False


def main() -> None:
    ps = ParkingSystem(1, 1, 0)
    print(ps.addCar(1))  # True
    print(ps.addCar(2))  # True
    print(ps.addCar(3))  # False


if __name__ == "__main__":
    main()
