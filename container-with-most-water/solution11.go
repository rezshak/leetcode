// https://leetcode.com/problems/container-with-most-water/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(1)
func maxArea(height []int) int {
	maxArea := 0
	start := 0
	end := len(height) - 1

	for start < end {
		width := end - start
		h := int(math.Min(float64(height[start]), float64(height[end])))
		maxArea = int(math.Max(float64(maxArea), float64(h*width)))
		if height[start] <= height[end] {
			start++
		} else {
			end--
		}
	}

	return maxArea
}

func main() {
	height1 := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	height2 := []int{1, 1}
	fmt.Println(maxArea(height1)) // 49
	fmt.Println(maxArea(height2)) // 1
}
