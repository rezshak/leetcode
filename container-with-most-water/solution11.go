// https://leetcode.com/problems/container-with-most-water/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func maxArea(height []int) int {
	left, right := 0, len(height)-1
	result := 0
	for left < right {
		width := right - left
		area := width * min(height[left], height[right])
		result = max(result, area)
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return result
}

func main() {
	height1 := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	height2 := []int{1, 1}
	fmt.Println(maxArea(height1)) // 49
	fmt.Println(maxArea(height2)) // 1
}
