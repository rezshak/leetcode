// https://leetcode.com/problems/permutation-in-string/

package main

import "fmt"

// T: O(n), S: O(1)
func checkInclusion(s1 string, s2 string) bool {
	n1, n2 := len(s1), len(s2)
	if n1 > n2 {
		return false
	}
	counts1, counts2 := make([]byte, 26), make([]byte, 26)
	for i := range n1 {
		counts1[s1[i]-'a']++
		counts2[s2[i]-'a']++
	}
	for i := n1; i < n2; i++ {
		if slicesEqual(counts1, counts2) {
			return true
		}
		counts2[s2[i-n1]-'a']--
		counts2[s2[i]-'a']++
	}
	return slicesEqual(counts1, counts2)
}

func slicesEqual(a, b []byte) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(checkInclusion("ab", "eidbaooo")) // true
	fmt.Println(checkInclusion("ab", "eidboaoo")) // false
	fmt.Println(checkInclusion("adc", "dcda"))    // true
}
