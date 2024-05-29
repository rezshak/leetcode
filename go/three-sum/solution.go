// https://leetcode.com/problems/3sum/

package main

import (
	"fmt"
	"sort"
)

// T: O(n^2), S: O(n)
func threeSum(nums []int) [][]int {
	set := make(map[[3]int]bool)
	sort.Ints(nums)
	n := len(nums)
	for i := 0; i < n-2; i++ {
		num1 := nums[i]
		left, right := i+1, n-1
		for left < right {
			num2 := nums[left]
			num3 := nums[right]
			currSum := num1 + num2 + num3
			if currSum == 0 {
				triplet := [3]int{num1, num2, num3}
				set[triplet] = true
				left++
				right--
				continue
			}
			if currSum < 0 {
				left++
			} else if currSum > 0 {
				right--
			}
		}
	}
	result := make([][]int, 0, len(set))
	for key := range set {
		result = append(result, key[:])
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
			currSum := nums[i] + nums[left] + nums[right]
			if currSum == 0 {
				result = append(result, []int{nums[i], nums[left], nums[right]})
				for left < right && nums[left] == nums[left+1] {
					left++
				}
				for left < right && nums[right] == nums[right-1] {
					right--
				}
				left++
				right--
			} else if currSum < 0 {
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
	fmt.Println(threeSum(nums1))
	fmt.Println(threeSum(nums2))
	fmt.Println(threeSum(nums3))
	fmt.Println(threeSumOpt(nums1))
	fmt.Println(threeSumOpt(nums2))
	fmt.Println(threeSumOpt(nums3))
}
