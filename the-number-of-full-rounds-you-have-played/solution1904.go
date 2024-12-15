// https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

// T: O(1), S: O(1)
func numberOfRounds(loginTime string, logoutTime string) int {
	toMinutes := func(time string) int {
		parts := strings.Split(time, ":")
		hours, _ := strconv.Atoi(parts[0])
		minutes, _ := strconv.Atoi(parts[1])
		return hours*60 + minutes
	}

	loginMins := toMinutes(loginTime)
	logoutMins := toMinutes(logoutTime)

	if logoutMins < loginMins {
		logoutMins += 24 * 60
	}

	loginRounded := ((loginMins + 14) / 15) * 15
	logoutRounded := (logoutMins / 15) * 15

	return max(0, (logoutRounded-loginRounded)/15)
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
