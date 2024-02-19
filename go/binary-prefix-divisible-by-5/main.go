// https://leetcode.com/problems/binary-prefix-divisible-by-5/

package main

import (
	"fmt"
)

func prefixesDivBy5(nums []int) []bool {
	result := make([]bool, len(nums))
	base10 := 0
	for i, base2 := range nums {
		base10 = ((base10 << 1) + base2) % 5
		result[i] = base10 == 0
	}
	return result
}

func main() {
	nums1 := []int{0, 1, 1} // [true,false,false]
	nums2 := []int{1, 1, 1} // [false,false,false]
	fmt.Println(prefixesDivBy5(nums1))
	fmt.Println(prefixesDivBy5(nums2))
}
