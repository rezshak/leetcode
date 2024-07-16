// https://leetcode.com/problems/faulty-sensor/

package main

import "fmt"

// T: O(n), S: O(1)
func badSensor(sensor1 []int, sensor2 []int) int {
	n := len(sensor1)
	mismatchIdx := -1
	for i := 0; i < n; i++ {
		if sensor1[i] != sensor2[i] {
			mismatchIdx = i
			break
		}
	}
	if mismatchIdx == -1 {
		return -1
	}
	sensor1Defective := isDefective(sensor1, sensor2, mismatchIdx)
	sensor2Defective := isDefective(sensor2, sensor1, mismatchIdx)
	if sensor1Defective && !sensor2Defective {
		return 1
	}
	if sensor2Defective && !sensor1Defective {
		return 2
	}
	return -1
}

func isDefective(sensor1, sensor2 []int, mismatchIdx int) bool {
	n := len(sensor1)
	for i := mismatchIdx; i < n-1; i++ {
		if sensor1[i] != sensor2[i+1] {
			return false
		}
	}
	return true
}

func main() {
	sensor1 := []int{2, 3, 4, 5}
	sensor2 := []int{2, 1, 3, 4}
	fmt.Println(badSensor(sensor1, sensor2)) // 1
	sensor1 = []int{2, 2, 2, 2, 2}
	sensor2 = []int{2, 2, 2, 2, 5}
	fmt.Println(badSensor(sensor1, sensor2)) // -1
	sensor1 = []int{2, 3, 2, 2, 3, 2}
	sensor2 = []int{2, 3, 2, 3, 2, 7}
	fmt.Println(badSensor(sensor1, sensor2)) // 2
}
