// https://leetcode.com/problems/next-greater-element-i/

package main

import "fmt"

// T: O(n), S: O(n)
func nextGreaterElement(nums1 []int, nums2 []int) []int {
	stack := []int{} // decreasing monotonic stack
	map2 := make(map[int]int)
	for i := len(nums2) - 1; i >= 0; i-- {
		num := nums2[i]
		for len(stack) > 0 && stack[len(stack)-1] <= num {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			map2[num] = -1
		} else {
			map2[num] = stack[len(stack)-1]
		}
		stack = append(stack, num)
	}
	res := make([]int, len(nums1))
	for i := 0; i < len(nums1); i++ {
		if val, ok := map2[nums1[i]]; ok {
			res[i] = val
		} else {
			res[i] = -1
		}
	}
	return res
}

// T: O(n*m), S: O(n)
func nextGreaterElementBrutOpt(nums1 []int, nums2 []int) []int {
	res := make([]int, len(nums1))
	nums2IdxMap := make(map[int]int)
	for i, num := range nums2 {
		nums2IdxMap[num] = i
	}
	for i, num := range nums1 {
		idx := nums2IdxMap[num]
		res[i] = nextGreater(nums2, num, idx+1)
	}
	return res
}

// T: O(n*m), S: O(1)
func nextGreaterElementBrute(nums1 []int, nums2 []int) []int {
	res := make([]int, len(nums1))
	for i, num := range nums1 {
		idx := indexOf(nums2, num)
		res[i] = nextGreater(nums2, num, idx+1)
	}
	return res
}

// T: O(n), S: O(1)
func indexOf(nums []int, num int) int {
	for i, n := range nums {
		if n == num {
			return i
		}
	}
	return -1
}

// T: O(n), S: O(1)
func nextGreater(nums []int, num int, idx int) int {
	for i := idx; i < len(nums); i++ {
		if nums[i] > num {
			return nums[i]
		}
	}
	return -1
}

func main() {
	var nums1 = []int{4, 1, 2}
	var nums2 = []int{1, 3, 4, 2}
	fmt.Println(nextGreaterElement(nums1, nums2))        // [-1 3 -1]
	fmt.Println(nextGreaterElementBrute(nums1, nums2))   // [-1 3 -1]
	fmt.Println(nextGreaterElementBrutOpt(nums1, nums2)) // [-1 3 -1]
	nums1 = []int{2, 4}
	nums2 = []int{1, 2, 3, 4}
	fmt.Println(nextGreaterElement(nums1, nums2))        // [3 -1]
	fmt.Println(nextGreaterElementBrute(nums1, nums2))   // [3 -1]
	fmt.Println(nextGreaterElementBrutOpt(nums1, nums2)) // [3 -1]
}
