// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(1)
func countPairs(nums []int, target int) int {
	sort.Ints(nums)
	left, right, count := 0, len(nums)-1, 0
	for left < right {
		sum := nums[left] + nums[right]
		if sum < target {
			count += (right - left)
			left++
		} else {
			right--
		}
	}
	return count
}

// T: O(n^2), S: O(1)
func countPairsBrute(nums []int, target int) int {
	n, count := len(nums), 0
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			if nums[i]+nums[j] < target {
				count++
			}
		}
	}
	return count
}

// T: O(n^2), S: O(n)
func countPairsMap(nums []int, target int) int {
	freqsMap := make(map[int]int)
	count := 0
	for _, num := range nums {
		for key := range freqsMap {
			if num+key < target {
				count++
			}
		}
		freqsMap[num]++
	}
	return count
}

func main() {
	var nums1 = []int{-1, 1, 2, 3, 1}
	var nums2 = []int{-6, 2, 5, -2, -7, -1, 3}
	fmt.Println(countPairs(nums1, 2))       // 3
	fmt.Println(countPairsBrute(nums1, 2))  // 3
	fmt.Println(countPairsMap(nums1, 2))    // 3
	fmt.Println(countPairs(nums2, -2))      // 10
	fmt.Println(countPairsBrute(nums2, -2)) // 10
	fmt.Println(countPairsMap(nums2, -2))   // 10
}
