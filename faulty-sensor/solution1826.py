# https://leetcode.com/problems/faulty-sensor/

from typing import List


class Solution1826:

    # T: O(n), S: O(1)
    def badSensor(self, sensor1: List[int], sensor2: List[int]) -> int:
        n = len(sensor1)
        mismatch_idx = -1
        for i in range(n):
            if sensor1[i] != sensor2[i]:
                mismatch_idx = i
                break
        if mismatch_idx == -1:
            return -1
        sensor1_defective = self.is_defective(sensor1, sensor2, mismatch_idx)
        sensor2_defective = self.is_defective(sensor2, sensor1, mismatch_idx)
        if sensor1_defective and not sensor2_defective:
            return 1
        if not sensor1_defective and sensor2_defective:
            return 2
        return -1

    def is_defective(self, sensor_a, sensor_b, mismatch_index):
        n = len(sensor_a)
        for i in range(mismatch_index, n - 1):
            if sensor_a[i] != sensor_b[i + 1]:
                return False
        return True


def main() -> None:
    sol = Solution1826()
    sensor1 = [2, 3, 4, 5]
    sensor2 = [2, 1, 3, 4]
    print(sol.badSensor(sensor1, sensor2))  # 1
    sensor1 = [2, 2, 2, 2, 2]
    sensor2 = [2, 2, 2, 2, 5]
    print(sol.badSensor(sensor1, sensor2))  # -1
    sensor1 = [2, 3, 2, 2, 3, 2]
    sensor2 = [2, 3, 2, 3, 2, 7]
    print(sol.badSensor(sensor1, sensor2))  # 2


if __name__ == "__main__":
    main()
