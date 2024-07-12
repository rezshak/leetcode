// https://leetcode.com/problems/sliding-window-maximum/

package main

import (
	"container/list"
	"fmt"
	"math"
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
	len := len(nums) - k + 1
	res := make([]int, len)
	p := 0
	for i := 0; i < len; i++ {
		winMax := maxBrute(nums, i, i+k)
		res[p] = winMax
		p++
	}
	return res
}

func maxBrute(nums []int, beg, end int) int {
	max := math.MinInt32
	for i := beg; i < end; i++ {
		if nums[i] > max {
			max = nums[i]
		}
	}
	return max
}

func main() {
	nums1 := []int{1, 3, -1, -3, 5, 3, 6, 7}
	result1 := maxSlidingWindow(nums1, 3)
	fmt.Println(result1) // [3,3,5,5,6,7]
	result2 := maxSlidingWindowBrute(nums1, 3)
	fmt.Println(result2) // [3,3,5,5,6,7]
}
