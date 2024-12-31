// https://leetcode.com/problems/compare-version-numbers/

// https://leetcode.com/problems/compare-version-numbers/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

// T: O(max(n,m)), S: O(n+m)
func compareVersion(version1 string, version2 string) int {
	v1Parts := strings.Split(version1, ".")
	v2Parts := strings.Split(version2, ".")
	maxLength := max(len(v1Parts), len(v2Parts))

	for i := 0; i < maxLength; i++ {
		v1Val := 0
		if i < len(v1Parts) {
			v1Val, _ = strconv.Atoi(v1Parts[i])
		}
		v2Val := 0
		if i < len(v2Parts) {
			v2Val, _ = strconv.Atoi(v2Parts[i])
		}

		if v1Val > v2Val {
			return 1
		} else if v1Val < v2Val {
			return -1
		}
	}

	return 0
}

func main() {
	fmt.Println(compareVersion("1.2", "1.10"))    // -1
	fmt.Println(compareVersion("1.01", "1.001"))  // 0
	fmt.Println(compareVersion("1.0", "1.0.0.0")) // 0
}
