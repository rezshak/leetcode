// https://leetcode.com/problems/minimum-common-value/

package main

import "fmt"

// T: O(n+m), S: O(1)
func getCommon(nums1, nums2 []int) int {
	n1, n2 := len(nums1), len(nums2)
	idx1, idx2 := 0, 0
	for idx1 < n1 && idx2 < n2 {
		num1, num2 := nums1[idx1], nums2[idx2]
		if num1 == num2 {
			return num1
		} else if num1 < num2 {
			idx1++
		} else {
			idx2++
		}
	}
	return -1
}

// T: O(n+m), S: O(n)
func getCommonSet(nums1, nums2 []int) int {
	seen := make(map[int]bool)
	for _, n := range nums1 {
		seen[n] = true
	}
	for _, n := range nums2 {
		if seen[n] {
			return n
		}
	}
	return -1
}

// T: O(nlogm), S: O(1)
func getCommonBinarySearch(nums1, nums2 []int) int {
	if len(nums2) > len(nums1) {
		return getCommonBinarySearch(nums2, nums1)
	}
	for _, n := range nums1 {
		if binarySearch(nums2, n) {
			return n
		}
	}
	return -1
}

func binarySearch(nums []int, target int) bool {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			return true
		}
	}
	return false
}

func main() {
	var nums1 = []int{1, 2, 3}
	var nums2 = []int{2, 4}
	fmt.Println(getCommon(nums1, nums2))             // 2
	fmt.Println(getCommonSet(nums1, nums2))          // 2
	fmt.Println(getCommonBinarySearch(nums1, nums2)) // 2
	nums1 = []int{1, 2, 3, 6}
	nums2 = []int{2, 3, 4, 5}
	fmt.Println(getCommon(nums1, nums2))             // 2
	fmt.Println(getCommonSet(nums1, nums2))          // 2
	fmt.Println(getCommonBinarySearch(nums1, nums2)) // 2
	nums1 = []int{1, 3, 5}
	nums2 = []int{2, 4, 6}
	fmt.Println(getCommon(nums1, nums2))             // -1
	fmt.Println(getCommonSet(nums1, nums2))          // -1
	fmt.Println(getCommonBinarySearch(nums1, nums2)) // -1
}
