// https://leetcode.com/problems/repeated-dna-sequences/

package main

import "fmt"

const k = 10

// T: O(n), S: O(n)
func findRepeatedDnaSequences(s string) []string {
	seen := make(map[string]int)
	result := make([]string, 0)
	for i := 0; i < len(s)-k+1; i++ {
		substr := s[i : i+k]
		seen[substr]++
		if seen[substr] == 2 {
			result = append(result, substr)
		}
	}
	return result
}

func main() {
	s1 := "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
	s2 := "AAAAAAAAAAAAA"
	fmt.Println(findRepeatedDnaSequences(s1))
	fmt.Println(findRepeatedDnaSequences(s2))
}
