// https://leetcode.com/problems/repeated-dna-sequences/

package main

import (
	"fmt"
	"math"
)

const K = 10

// T: O(n*k), S: O(n*k)
func findRepeatedDnaSequences(s string) []string {
	if len(s) < K {
		return []string{}
	}

	counts := make(map[string]int)
	result := []string{}

	for i := 0; i <= len(s)-K; i++ {
		seq := s[i : i+K]
		counts[seq]++
		if counts[seq] == 2 {
			result = append(result, seq)
		}
	}

	return result
}

var charMap = map[byte]int{
	'A': 0,
	'C': 1,
	'G': 2,
	'T': 3,
}

// T: O(n), S: O(n)
func findRepeatedDnaSequencesRabinKarp(s string) []string {
	if len(s) < K {
		return []string{}
	}

	seenHashes := make(map[int]struct{})
	repeatedSequences := make(map[string]struct{})
	rollingHash := 0
	base := 4
	hashSize := int(math.Pow(float64(base), float64(K-1)))

	for i := 0; i < K; i++ {
		rollingHash = rollingHash*base + charMap[s[i]]
	}
	seenHashes[rollingHash] = struct{}{}

	for i := 1; i <= len(s)-K; i++ {
		rollingHash = rollingHash - charMap[s[i-1]]*hashSize
		rollingHash = rollingHash*base + charMap[s[i+K-1]]

		if _, exists := seenHashes[rollingHash]; exists {
			repeatedSequences[s[i:i+K]] = struct{}{}
		} else {
			seenHashes[rollingHash] = struct{}{}
		}
	}

	result := make([]string, 0, len(repeatedSequences))
	for seq := range repeatedSequences {
		result = append(result, seq)
	}

	return result
}

func main() {
	s1 := "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
	s2 := "AAAAAAAAAAAAA"
	fmt.Println(findRepeatedDnaSequences(s1))          // ["AAAAACCCCC", "CCCCCAAAAA"]
	fmt.Println(findRepeatedDnaSequences(s2))          // ["AAAAAAAAAA"]
	fmt.Println(findRepeatedDnaSequencesRabinKarp(s1)) // ["AAAAACCCCC", "CCCCCAAAAA"]
	fmt.Println(findRepeatedDnaSequencesRabinKarp(s2)) // ["AAAAAAAAAA"]
}
