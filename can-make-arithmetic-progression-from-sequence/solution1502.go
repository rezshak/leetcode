// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(1)
func canMakeArithmeticProgression(arr []int) bool {
	sort.Ints(arr)
	diff := arr[1] - arr[0]
	for i := 1; i < len(arr)-1; i++ {
		if arr[i+1]-arr[i] != diff {
			return false
		}
	}
	return true
}

// T: O(n), S: O(n)
func canMakeArithmeticProgressionSet(arr []int) bool {
	n := len(arr)
	if n <= 2 {
		return true
	}
	min, max := arr[0], arr[0]
	for _, num := range arr {
		if num < min {
			min = num
		}
		if num > max {
			max = num
		}
	}

	// Calculate the common difference
	if (max-min)%(n-1) != 0 {
		return false
	}
	diff := (max - min) / (n - 1)

	// If the difference is zero, all elements must be the same
	if diff == 0 {
		return true
	}

	set := make(map[int]bool)
	for _, num := range arr {
		// Check if each number is in the arithmetic progression sequence
		if (num-min)%diff != 0 {
			return false
		}
		set[num] = true
	}

	// Check if all numbers in the arithmetic sequence are present
	return len(set) == n
}

func main() {
	arr1 := []int{3, 5, 1}
	arr2 := []int{1, 2, 4}
	fmt.Println(canMakeArithmeticProgression(arr1))    // true
	fmt.Println(canMakeArithmeticProgressionSet(arr1)) // true
	fmt.Println(canMakeArithmeticProgression(arr2))    // false
	fmt.Println(canMakeArithmeticProgressionSet(arr2)) // false
}
