// https://leetcode.com/problems/valid-anagram/

package main

import "fmt"

// T: O(n), S: O(1)
func isAnagram(s, t string) bool {
	if len(s) != len(t) {
		return false
	}
	counts := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		counts[s[i]]++
		counts[t[i]]--
	}
	for _, count := range counts {
		if count != 0 {
			return false
		}
	}
	return true
}

func main() {
	var s1, t1 = "anagram", "nagaram"
	fmt.Println(isAnagram(s1, t1)) // true
	var s2, t2 = "rat", "car"
	fmt.Println(isAnagram(s2, t2)) // false
}
