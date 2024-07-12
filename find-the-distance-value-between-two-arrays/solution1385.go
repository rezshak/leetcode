// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

package main

import (
	"fmt"
	"sort"
)

// T: O(nm), S: O(1)
func findTheDistanceValue(arr1 []int, arr2 []int, d int) int {
	count := len(arr1)
	for _, n1 := range arr1 {
		for _, n2 := range arr2 {
			absDiff := abs(n1 - n2)
			if absDiff <= d {
				count--
				break
			}
		}
	}
	return count
}

// T: O(nlogn), S: O(1)
func findTheDistanceValueOpt(arr1 []int, arr2 []int, d int) int {
	sort.Ints(arr2)
	count := 0
	for _, n := range arr1 {
		if isDistanceValue(n, arr2, d) {
			count++
		}
	}
	return count
}

func isDistanceValue(n int, arr2 []int, d int) bool {
	left, right := 0, len(arr2)-1
	for left <= right {
		mid := left + (right-left)/2
		if abs(n-arr2[mid]) <= d {
			return false
		} else if arr2[mid] < n {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return true
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func main() {
	arr1 := []int{4, 5, 8}
	arr2 := []int{10, 9, 1, 8}
	fmt.Println(findTheDistanceValue(arr1, arr2, 2))    // 2
	fmt.Println(findTheDistanceValueOpt(arr1, arr2, 2)) // 2
	arr1 = []int{1, 4, 2, 3}
	arr2 = []int{-4, -3, 6, 10, 20, 30}
	fmt.Println(findTheDistanceValue(arr1, arr2, 3))    // 2
	fmt.Println(findTheDistanceValueOpt(arr1, arr2, 3)) // 2
	arr1 = []int{2, 1, 100, 3}
	arr2 = []int{-5, -2, 10, -3, 7}
	fmt.Println(findTheDistanceValue(arr1, arr2, 6))    // 1
	fmt.Println(findTheDistanceValueOpt(arr1, arr2, 6)) // 1
}
