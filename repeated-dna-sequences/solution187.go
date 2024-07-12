// https://leetcode.com/problems/repeated-dna-sequences/

package main

import (
	"fmt"
	"math"
)

const K = 10

// T: O(n), S: O(n)
func findRepeatedDnaSequences(s string) []string {
	seen := make(map[string]int)
	result := make([]string, 0)
	for i := 0; i < len(s)-K+1; i++ {
		substr := s[i : i+K]
		seen[substr]++
		if seen[substr] == 2 {
			result = append(result, substr)
		}
	}
	return result
}

var MAP = map[rune]int{
	'A': 0,
	'C': 1,
	'G': 2,
	'T': 3,
}

// T: O(n), S: O(n)
func findRepeatedDnaSequencesRabinKarp(s string) []string {
	len := len(s)
	if len < K {
		return []string{}
	}

	arr := make([]int, len)
	for i := 0; i < len; i++ {
		arr[i] = MAP[rune(s[i])]
	}

	a := 4
	currHash := 0

	seen := make(map[int]bool)
	result := make(map[string]bool)

	for i := 0; i < len-K+1; i++ {
		if i == 0 {
			for j := 0; j < K; j++ {
				currHash += arr[j] * int(math.Pow(float64(a), float64(K-j-1)))
			}
		} else {
			prevHash := currHash
			currHash = ((prevHash - arr[i-1]*int(math.Pow(float64(a), float64(K-1)))) * a) + arr[i+K-1]
		}

		if seen[currHash] {
			result[s[i:i+K]] = true
		}

		seen[currHash] = true
	}

	var res []string
	for k := range result {
		res = append(res, k)
	}
	return res
}

func main() {
	s1 := "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
	s2 := "AAAAAAAAAAAAA"
	fmt.Println(findRepeatedDnaSequences(s1))
	fmt.Println(findRepeatedDnaSequences(s2))
	fmt.Println(findRepeatedDnaSequencesRabinKarp(s1))
	fmt.Println(findRepeatedDnaSequencesRabinKarp(s2))
}
