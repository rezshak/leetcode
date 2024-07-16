// https://leetcode.com/problems/faulty-sensor/

class Solution1826 {

    // T: O(n), S: O(1)
    public int badSensor(int[] sensor1, int[] sensor2) {
        int n = sensor1.length;
        int mismatchIdx = -1;
        for (int i = 0; i < n; i++) {
            if (sensor1[i] != sensor2[i]) {
                mismatchIdx = i;
                break;
            }
        }
        if (mismatchIdx == -1) {
            return -1;
        }
        boolean sensor1Defective = isDefective(sensor1, sensor2, mismatchIdx);
        boolean sensor2Defective = isDefective(sensor2, sensor1, mismatchIdx);
        if (sensor1Defective && !sensor2Defective) {
            return 1;
        }
        if (!sensor1Defective && sensor2Defective) {
            return 2;
        }
        return -1;
    }

    private static boolean isDefective(int[] sensorA, int[] sensorB, int mismatchIndex) {
        int n = sensorA.length;
        for (int i = mismatchIndex; i < n - 1; i++) {
            if (sensorA[i] != sensorB[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution1826();
        var sensor1 = new int[] { 2, 3, 4, 5 };
        var sensor2 = new int[] { 2, 1, 3, 4 };
        System.out.println(sol.badSensor(sensor1, sensor2)); // 1
        sensor1 = new int[] { 2, 2, 2, 2, 2 };
        sensor2 = new int[] { 2, 2, 2, 2, 5 };
        System.out.println(sol.badSensor(sensor1, sensor2)); // -1
        sensor1 = new int[] { 2, 3, 2, 2, 3, 2 };
        sensor2 = new int[] { 2, 3, 2, 3, 2, 7 };
        System.out.println(sol.badSensor(sensor1, sensor2)); // 2
    }

}
