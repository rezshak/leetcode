// https://leetcode.com/problems/trapping-rain-water/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func trap(heights []int) int {
	left, right := 0, len(heights)-1
	leftMax, rightMax := 0, 0
	storedWater := 0

	for left <= right {
		if leftMax <= rightMax {
			storedWater += max(0, leftMax-heights[left])
			leftMax = max(leftMax, heights[left])
			left++
		} else {
			storedWater += max(0, rightMax-heights[right])
			rightMax = max(rightMax, heights[right])
			right--
		}
	}

	return storedWater
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	height1 := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	height2 := []int{4, 2, 0, 3, 2, 5}
	fmt.Println(trap(height1)) // 6
	fmt.Println(trap(height2)) // 9
}
