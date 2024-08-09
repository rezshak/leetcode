// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

package main

import (
	"fmt"
	"math"
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
	set := make(map[int]bool)
	minVal := math.MaxInt32
	maxVal := math.MinInt32
	for _, n := range arr {
		if n < minVal {
			minVal = n
		}
		if n > maxVal {
			maxVal = n
		}
		set[n] = true
	}
	if len(set) == 1 {
		return true
	}
	if len(set) != len(arr) {
		return false
	}
	diff := (maxVal - minVal) / (len(arr) - 1)
	if diff == 0 {
		return true
	}
	for i := 0; i < len(arr); i++ {
		if _, exists := set[minVal+i*diff]; !exists {
			return false
		}
	}
	return true
}

func main() {
	arr1 := []int{3, 5, 1}
	arr2 := []int{1, 2, 4}
	fmt.Println(canMakeArithmeticProgression(arr1))    // true
	fmt.Println(canMakeArithmeticProgressionSet(arr1)) // true
	fmt.Println(canMakeArithmeticProgression(arr2))    // false
	fmt.Println(canMakeArithmeticProgressionSet(arr2)) // false
}
