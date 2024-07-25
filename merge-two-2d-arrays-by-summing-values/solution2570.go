// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

package main

import (
	"fmt"
	"sort"
)

// T: O: (nlogn), S: O(n)
func mergeArrays(nums1 [][]int, nums2 [][]int) [][]int {
	dict := make(map[int]int)
	for _, row := range nums1 {
		dict[row[0]] = row[1]
	}
	for _, row := range nums2 {
		dict[row[0]] += row[1]
	}
	keys := make([]int, 0, len(dict))
	for key := range dict {
		keys = append(keys, key)
	}
	sort.Ints(keys)
	result := make([][]int, len(keys))
	for i, key := range keys {
		result[i] = []int{key, dict[key]}
	}
	return result
}

// T: O(n+m), S: O(n+m)
func mergeArraysTwoPtr(nums1 [][]int, nums2 [][]int) [][]int {
	len1, len2 := len(nums1), len(nums2)
	ans := make([][]int, 0, len1+len2)
	r1, r2 := 0, 0
	for r1 < len1 && r2 < len2 {
		if nums1[r1][0] == nums2[r2][0] {
			ans = append(ans, []int{nums1[r1][0], nums1[r1][1] + nums2[r2][1]})
			r1++
			r2++
		} else if nums1[r1][0] < nums2[r2][0] {
			ans = append(ans, []int{nums1[r1][0], nums1[r1][1]})
			r1++
		} else {
			ans = append(ans, []int{nums2[r2][0], nums2[r2][1]})
			r2++
		}
	}
	for r1 < len1 {
		ans = append(ans, []int{nums1[r1][0], nums1[r1][1]})
		r1++
	}

	for r2 < len2 {
		ans = append(ans, []int{nums2[r2][0], nums2[r2][1]})
		r2++
	}
	return ans
}

func main() {
	nums1 := [][]int{{1, 2}, {3, 4}}
	nums2 := [][]int{{1, 3}, {5, 6}}
	fmt.Println(mergeArrays(nums1, nums2))
	fmt.Println(mergeArraysTwoPtr(nums1, nums2))
	nums1 = [][]int{{2, 4}, {3, 6}, {5, 5}}
	nums2 = [][]int{{1, 3}, {4, 3}}
	fmt.Println(mergeArrays(nums1, nums2))
	fmt.Println(mergeArraysTwoPtr(nums1, nums2))
}
