// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

package main

import (
	"fmt"
	"sort"
)

// T: O(n), S: O(n)
func findMaxK(nums []int) int {
	seen := make(map[int]bool)
	for _, n := range nums {
		seen[n] = true
	}
	ans := -1
	for n := range seen {
		if n > 0 && seen[-n] {
			ans = max(ans, n)
		}
	}
	return ans
}

// T: O(n), S: O(n)
func findMaxKOnePass(nums []int) int {
	seen := make(map[int]bool)
	ans := -1
	for _, num := range nums {
		absNum := abs(num)
		if absNum > ans && seen[-num] {
			ans = max(ans, absNum)
		}
		seen[num] = true
	}
	return ans
}

// T: O(n), S: O(1)
func findMaxKBitset(nums []int) int {
	pos := make([]bool, 1001)
	neg := make([]bool, 1001)
	for _, n := range nums {
		if n > 0 {
			pos[n] = true
		} else if n < 0 {
			neg[-n] = true
		}
	}
	ans := -1
	for n := 1000; n > 0; n-- {
		if pos[n] && neg[n] {
			ans = max(ans, n)
		}
	}
	return ans
}

// T: O(nlogn), S: O(1)
func findMaxKBinarySearch(nums []int) int {
	sort.Ints(nums)
	ans, left, right := -1, 0, len(nums)-1
	for left < right {
		sum := nums[left] + nums[right]
		if sum == 0 {
			ans = max(ans, nums[right])
			left++
			right--
		} else if sum < 0 {
			left++
		} else {
			right--
		}
	}
	return ans
}

// T: O(n^2), S: O(1)
func findMaxKBrute(nums []int) int {
	ans := -1
	for i := 0; i < len(nums)-1; i++ {
		n1 := nums[i]
		for j := i + 1; j < len(nums); j++ {
			n2 := nums[j]
			if n1 == -n2 {
				ans = max(ans, abs(n1))
			}
		}
	}
	return ans
}

func abs(n int) int {
	if n < 0 {
		return -n
	}
	return n
}

func main() {
	var nums1 = []int{-1, 2, -3, 3}
	var nums2 = []int{-1, 10, 6, 7, -7, 1}
	var nums3 = []int{-10, 8, 6, 7, -2, -3}
	fmt.Println(findMaxK(nums1))             // 3
	fmt.Println(findMaxKOnePass(nums1))      // 3
	fmt.Println(findMaxKBitset(nums1))       // 3
	fmt.Println(findMaxKBinarySearch(nums1)) // 3
	fmt.Println(findMaxKBrute(nums1))        // 3
	fmt.Println(findMaxK(nums2))             // 7
	fmt.Println(findMaxKOnePass(nums2))      // 7
	fmt.Println(findMaxKBitset(nums2))       // 7
	fmt.Println(findMaxKBinarySearch(nums2)) // 7
	fmt.Println(findMaxKBrute(nums2))        // 7
	fmt.Println(findMaxK(nums3))             // -1
	fmt.Println(findMaxKOnePass(nums3))      // -1
	fmt.Println(findMaxKBitset(nums3))       // -1
	fmt.Println(findMaxKBinarySearch(nums3)) // -1
	fmt.Println(findMaxKBrute(nums3))        // -1
}
