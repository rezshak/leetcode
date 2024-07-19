// https://leetcode.com/problems/number-of-arithmetic-triplets/

package main

import "fmt"

// T: O(n), S: O(n)
func arithmeticTriplets(nums []int, diff int) int {
	numSet := make(map[int]bool)
	for _, n := range nums {
		numSet[n] = true
	}
	count := 0
	for _, n := range nums {
		if numSet[n+diff] && numSet[n+diff+diff] {
			count++
		}
	}
	return count
}

// T: O(n^3), S: O(n^3)
func arithmeticTripletsBrute(nums []int, diff int) int {
	count, n := 0, len(nums)
	for i := 0; i < n-2; i++ {
		n1 := nums[i]
		for j := i + 1; j < n-1; j++ {
			n2 := nums[j]
			if n2 == n1+diff {
				for k := j + 1; k < n; k++ {
					n3 := nums[k]
					if n3 == n2+diff {
						count++
					}
				}
			}
		}
	}
	return count
}

func main() {
	var nums1 = []int{0, 1, 4, 6, 7, 10}
	var nums2 = []int{4, 5, 6, 7, 8, 9}
	fmt.Println(arithmeticTriplets(nums1, 3))      // 2
	fmt.Println(arithmeticTripletsBrute(nums1, 3)) // 2
	fmt.Println(arithmeticTriplets(nums2, 2))      // 2
	fmt.Println(arithmeticTripletsBrute(nums2, 2)) // 2
}
