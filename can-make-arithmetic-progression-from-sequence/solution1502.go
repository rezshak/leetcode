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
	minVal, maxVal := math.MaxInt32, math.MinInt32
	n := len(arr)
	for _, num := range arr {
		if num < minVal {
			minVal = num
		}
		if num > maxVal {
			maxVal = num
		}
	}
	if maxVal-minVal == 0 {
		return true
	}
	if (maxVal-minVal)%(n-1) != 0 {
		return false
	}
	diff := (maxVal - minVal) / (n - 1)
	set := make(map[int]bool)
	for _, num := range arr {
		if (num-minVal)%diff != 0 {
			return false
		}
		set[num] = true
	}
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
