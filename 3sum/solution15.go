// https://leetcode.com/problems/3sum/

package main

import (
	"fmt"
	"sort"
)

// T: O(n^2), S: O(n)
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	set := make(map[[3]int]bool)
	result := make([][]int, 0)
	for i, n1 := range nums {
		left, right := i+1, len(nums)-1
		for left < right {
			n2, n3 := nums[left], nums[right]
			sum := n1 + n2 + n3
			if sum == 0 {
				triplet := [3]int{n1, n2, n3}
				if _, found := set[triplet]; !found {
					set[triplet] = true
					result = append(result, triplet[:])
				}
				left++
				right--
			} else if sum < 0 {
				left++
			} else {
				right--
			}
		}
	}
	return result
}

// T: O(n^2), S: O(n)
func threeSumOpt(nums []int) [][]int {
	sort.Ints(nums)
	result := [][]int{}
	n := len(nums)
	for i := 0; i < n-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		left, right := i+1, n-1
		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == 0 {
				result = append(result, []int{nums[i], nums[left], nums[right]})
				for left < right && nums[left] == nums[left+1] {
					left++
				}
				for left < right && nums[right] == nums[right-1] {
					right--
				}
				left++
				right--
			} else if sum < 0 {
				left++
			} else {
				right--
			}
		}
	}
	return result
}

func main() {
	nums1 := []int{-1, 0, 1, 2, -1, -4}
	nums2 := []int{0, 1, 1}
	nums3 := []int{0, 0, 0}
	fmt.Println(threeSum(nums1))    // [[-1 -1 2] [-1 0 1]]
	fmt.Println(threeSumOpt(nums1)) // [[-1 -1 2] [-1 0 1]]
	fmt.Println(threeSum(nums2))    // []
	fmt.Println(threeSumOpt(nums2)) // []
	fmt.Println(threeSum(nums3))    // [[0 0 0]]
	fmt.Println(threeSumOpt(nums3)) // [[0 0 0]]
}
