// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/

package main

import "fmt"

// T: O(n), S: O(1)
func captureForts(forts []int) int {
	ans := 0
	for r, l := 0, 0; r < len(forts); r++ {
		if forts[r] != 0 {
			if forts[l] == -forts[r] {
				ans = max(ans, r-l-1)
			}
			l = r
		}
	}
	return ans
}

func main() {
	var forts1 = []int{1, 0, 0, -1, 0, 0, 0, 0, 1}
	var forts2 = []int{0, 0, 1, -1}
	fmt.Println(captureForts(forts1)) // 4
	fmt.Println(captureForts(forts2)) // 0
}
