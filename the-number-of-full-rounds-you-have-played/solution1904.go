// https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

// T: O(1), S: O(1)
func numberOfRounds(loginTime string, logoutTime string) int {
	startMinutes := getMinutes(loginTime)
	finishMinutes := getMinutes(logoutTime)

	if finishMinutes < startMinutes {
		finishMinutes += 24 * 60
	}

	roundedStart := (startMinutes + 14) / 15 * 15
	roundedFinish := finishMinutes / 15 * 15

	return max(0, (roundedFinish-roundedStart)/15)
}

func getMinutes(time string) int {
	parts := strings.Split(time, ":")
	hrs, _ := strconv.Atoi(parts[0])
	min, _ := strconv.Atoi(parts[1])
	return hrs*60 + min
}

func main() {
	fmt.Println(numberOfRounds("09:31", "10:14")) // 1
	fmt.Println(numberOfRounds("21:30", "03:00")) // 22
}
