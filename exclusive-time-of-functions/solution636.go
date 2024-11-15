// https://leetcode.com/problems/exclusive-time-of-functions/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

// T: O(n), S: O(n)
func exclusiveTime(n int, logs []string) []int {
	result := make([]int, n)
	stack := []int{}
	prevTime := 0

	for _, entry := range logs {
		arr := strings.Split(entry, ":")
		id, _ := strconv.Atoi(arr[0])
		typ := arr[1]
		time, _ := strconv.Atoi(arr[2])

		if typ == "start" {
			if len(stack) > 0 {
				prevId := stack[len(stack)-1]
				result[prevId] += time - prevTime
			}
			stack = append(stack, id)
			prevTime = time
		} else {
			prevId := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			result[prevId] += time - prevTime + 1
			prevTime = time + 1
		}
	}

	return result
}

func main() {
	logs1 := []string{"0:start:0", "1:start:2", "1:end:5", "0:end:6"}
	logs2 := []string{"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"}
	logs3 := []string{"0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"}

	fmt.Println(exclusiveTime(2, logs1)) // [3, 4]
	fmt.Println(exclusiveTime(1, logs2)) // [8]
	fmt.Println(exclusiveTime(2, logs3)) // [7, 1]
}
