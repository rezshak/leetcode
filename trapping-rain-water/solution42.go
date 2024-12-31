// https://leetcode.com/problems/trapping-rain-water/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func trap(height []int) int {
	if len(height) < 3 {
		return 0
	}

	left, right := 0, len(height)-1
	leftMax, rightMax := 0, 0
	totalWater := 0

	for left < right {
		if height[left] > leftMax {
			leftMax = height[left]
		}
		if height[right] > rightMax {
			rightMax = height[right]
		}

		if leftMax < rightMax {
			totalWater += leftMax - height[left]
			left++
		} else {
			totalWater += rightMax - height[right]
			right--
		}
	}

	return totalWater
}

func main() {
	height1 := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	height2 := []int{4, 2, 0, 3, 2, 5}
	fmt.Println(trap(height1)) // 6
	fmt.Println(trap(height2)) // 9
}
