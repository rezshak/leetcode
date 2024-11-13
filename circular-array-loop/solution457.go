// https://leetcode.com/problems/circular-array-loop/
package main

import "fmt"

// T: O(n), O(1)
func circularArrayLoop(nums []int) bool {
	n := len(nums)
	for i := 0; i < n; i++ {
		if nums[i] == 0 {
			continue
		}
		slow, fast := i, i
		for nums[fast]*nums[i] > 0 && nums[nextIndex(nums, fast)]*nums[i] > 0 {
			slow = nextIndex(nums, slow)
			fast = nextIndex(nums, nextIndex(nums, fast))
			if slow == fast {
				if slow == nextIndex(nums, slow) {
					break
				}
				return true
			}
		}
		slow = i
		val := nums[i]
		for nums[slow]*val > 0 {
			next := nextIndex(nums, slow)
			nums[slow] = 0
			slow = next
		}
	}
	return false
}

func nextIndex(nums []int, i int) int {
	n := len(nums)
	return ((i+nums[i])%n + n) % n
}

func main() {
	sol := circularArrayLoop
	nums1 := []int{2, -1, 1, 2, 2}
	nums2 := []int{-1, -2, -3, -4, -5, 6}
	nums3 := []int{1, -1, 5, 1, 4}
	fmt.Println(sol(nums1)) // true
	fmt.Println(sol(nums2)) // false
	fmt.Println(sol(nums3)) // true
}
