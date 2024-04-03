package main

import (
	"container/list"
	"fmt"
)

// T: O(n), S: O(n)
func maxSlidingWindow(nums []int, k int) []int {
	dq := list.New()
	n := len(nums)
	result := make([]int, n-k+1)
	idx := 0
	for i := 0; i < n; i++ {
		for dq.Len() > 0 && nums[i] >= nums[dq.Back().Value.(int)] {
			dq.Remove(dq.Back())
		}
		dq.PushBack(i)
		if i-dq.Front().Value.(int) >= k {
			dq.Remove(dq.Front())
		}
		if i >= k-1 {
			result[idx] = nums[dq.Front().Value.(int)]
			idx++
		}
	}
	return result
}

// T: O(nk), S: O(n)
func maxSlidingWindowBrute(nums []int, k int) []int {
	l, r, n := 0, k, len(nums)
	result := []int{}
	for r <= n {
		max := maxBrute(nums, l, r)
		result = append(result, max)
		l++
		r++
	}
	return result
}

func maxBrute(nums []int, l int, r int) int {
	max := -1 << 31
	for l < r {
		if nums[l] > max {
			max = nums[l]
		}
		l++
	}
	return max
}

func main() {
	nums1 := []int{1, 3, -1, -3, 5, 3, 6, 7}
	result1 := maxSlidingWindow(nums1, 3) // [3,3,5,5,6,7]
	fmt.Println(result1)
	result2 := maxSlidingWindowBrute(nums1, 3) // [3,3,5,5,6,7]
	fmt.Println(result2)
}
