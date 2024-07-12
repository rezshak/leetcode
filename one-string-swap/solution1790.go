// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

package main

import "fmt"

// T: O(n), S: O(1)
func areAlmostEqual(s1 string, s2 string) bool {
	counts1 := make([]int, 26)
	counts2 := make([]int, 26)
	diffs := 0
	for i := 0; i < len(s1); i++ {
		if s1[i] != s2[i] {
			diffs++
		}
		counts1[s1[i]-'a']++
		counts2[s2[i]-'a']++
	}
	if !arraysEqual(counts1, counts2) {
		return false
	}
	return diffs == 2 || diffs == 0
}

func arraysEqual(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(areAlmostEqual("bank", "kanb"))     // true
	fmt.Println(areAlmostEqual("attack", "defend")) // false
	fmt.Println(areAlmostEqual("kelb", "kelb"))     // true
	fmt.Println(areAlmostEqual("caa", "aaz"))       // false
}
