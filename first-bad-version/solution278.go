// https://leetcode.com/problems/first-bad-version/

package main

import "fmt"

func isBadVersion(n int) bool {
	return n >= 4
}

// T: O(log n), S: O(1)
func firstBadVersion(n int) int {
	left, right := 1, n
	for left < right {
		mid := left + (right-left)/2
		if isBadVersion(mid) {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}

func main() {
	fmt.Println(firstBadVersion(5)) // 4
}
